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
    this.jdbcContext = new JdbcContext (dataSource);
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        new JdbcContext(dataSource).jdbcContextWithStatementStrategy(new AddAllStrategy(user)); // add 쿼리 예외처리까지 된 상태의 메소드가 1줄로 완성

    }

    public User select(String id) throws SQLException, ClassNotFoundException {
            Connection c = dataSource.getConnection();//connectionMaker.makeConnection();
            PreparedStatement ps = c.prepareStatement("SELECT * FROM users where id =?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();


            rs.next();
            User user = new User(rs.getString("id"), rs.getString("name"), rs.getString("password"));


            rs.close();
            ps.close();
            c.close();

            return user;
    }

    public void deleteAll() throws SQLException, ClassNotFoundException {
       new JdbcContext(dataSource).jdbcContextWithStatementStrategy(new DeleteAlllStrategy());
    }

//        public int getCount () throws SQLException {
//
//        }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        UserDao userDao = new UserDao(new UserdaoFactory().awsdataSource());
        userDao.add(new User("1", "ss" ,"1234"));


    }
}


