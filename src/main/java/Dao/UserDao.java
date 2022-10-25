package Dao;

import domein.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDao {
    private DataSource dataSource;
    private JdbcContext jdbcContext;
    UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
   UserDao(JdbcContext jdbcContext){
        this.jdbcContext = new JdbcContext(dataSource);
   }

    public void add(User user) throws ClassNotFoundException, SQLException {
       jdbcContext.workWithStatmentStrategy(new StatmentStrategy() {
            @Override
            public PreparedStatement makeStstment(Connection conn) throws SQLException {
                PreparedStatement pstmt = conn.prepareStatement("INSERT INTO users(id, name, password) VALUES(?,?,?);");
                pstmt.setString(1, user.getId());
                pstmt.setString(2, user.getName());
                pstmt.setString(3, user.getPassword());

                return conn.prepareStatement("INSERT INTO users(id, name, password) VALUES(?,?,?);");
            } // 익명 클래스 닫기
        });
    }
     // add 쿼리 예외처리까지 된 상태

//    public User select(String id) throws SQLException, ClassNotFoundException {
//         jdbcContext.workWithStatmentStrategy(new StatmentStrategy() {
//             @Override
//             public PreparedStatement makeStstment(Connection conn) throws SQLException {
//                 conn = .setString(1, id);
//                 User user = new User(rs.getString("id"), rs.getString("name"), rs.getStrin
//                 return null;
//             }
//         });
//       g("password"));
//            return user;
//    }

    public void deleteAll() throws SQLException, ClassNotFoundException {
        jdbcContext.excutesql("delete from users");}


    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        UserDao userDao = new UserDao(new UserdaoFactory().awsdataSource());
        userDao.deleteAll();
        userDao.add(new User("1", "ss" ,"1234"));


    }
}


