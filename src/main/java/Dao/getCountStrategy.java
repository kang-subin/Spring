package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class getCountStrategy implements StatmentStrategy{


    @Override
    public PreparedStatement makeStstment(Connection conn) throws SQLException {
        int count;
        return conn.prepareStatement("");



    }
}
