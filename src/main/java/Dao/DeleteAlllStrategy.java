package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteAlllStrategy implements StatmentStrategy {
    @Override
    public PreparedStatement makeStstment(Connection conn) throws SQLException {

        return conn.prepareStatement("delete from users"); // delete 쿼리문 바로 사용하게 해주는 메소드
    }
}
