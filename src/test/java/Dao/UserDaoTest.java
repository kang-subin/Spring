package Dao;

import domein.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class) // junit 에서 applicationcontext 쓰게 해주는 기능
@ContextConfiguration(classes = UserdaoFactory.class) // bean을 조종하는 중간 매개체 = (위치)
class UserDaoTest {

  @Autowired
  ApplicationContext context; // 싱글톤 적용 = context 를 객체로 생성하여 메소드가 실행 될 때 마다 context를  계속 생성하지 않음 contxet는 참조변수라 이름 변경가능
  UserDao userDao = context.getBean("awsdao", UserDao.class);
  User user1 = new User("1", "subin", "1234");
  User user2 = new User("2", "yi", "1234");
  User user3 = new User("3", "sa", "1234");


  @BeforeEach
    // 테스트 코드 실행할 때 맨 처음 실행해주는 (공통적인 부분) 묶어논 것
  void setUp() {
    UserDao userDao = context.getBean("awsdao", UserDao.class);
  }

  @Test
  public void addAndGet() throws SQLException, ClassNotFoundException {
    UserDao userDao = new UserDao(new UserdaoFactory().awsdataSource());
    userDao.add(new User("1", "aa", "1234"));
    userDao.select(new User().getId());
    Assertions.assertEquals("1", new User().getId());
  }

  @Test
  public void deleteAll() {

  }
}