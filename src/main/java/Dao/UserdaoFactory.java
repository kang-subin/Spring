package Dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Map;

@Configuration // 객체 설정 담당하는 클래스를 인식시켜줌 , 이 어노테이션이 붇는 클래스를 스캔해서 applicationContext에 담음
public class UserdaoFactory { // 인터페이스를 골라서 내가 userdao에 주입하는 것과 달리 미리 주입되어 있는 클래스의 메소드를 호출하는 방법 (제어의 역전)
    @Bean
    public UserDao awsdao() throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao(awsdataSource());
        return userDao;
    }

    @Bean
    DataSource awsdataSource() {
        Map<String, String> env = System.getenv();
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
        dataSource.setUrl(env.get("DB_HOST"));
        dataSource.setUsername(env.get("DB_USER"));
        dataSource.setPassword(env.get("DB_PASSWORD"));
        return dataSource;
    }
}



