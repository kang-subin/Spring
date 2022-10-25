package Dao;

import domein.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddAllStrategy implements StatmentStrategy {
    private final User user;
    DataSource dataSource;

    public AddAllStrategy(User user){
        this.user =user;
        this.dataSource =  new AddAllStrategy(dataSource);
    }


    @Override
    public PreparedStatement makeStstment(Connection conn) throws SQLException {
        conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(("INSERT INTO users(id, name, password) VALUES(?,?,?);"));
        pstmt.setString(1, user.getId());
        pstmt.setString(2, user.getName());
        pstmt.setString(3, user.getPassword());
// add의 경우 user을 통해서 값을 주입해야 하기 때문에 addallstrategy 클래스에 user를 받을 수 있도록 생성자를 만들어서 클래스를 구현하엿다
        return pstmt;
    }
}
