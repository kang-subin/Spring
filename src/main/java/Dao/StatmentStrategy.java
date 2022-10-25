package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface StatmentStrategy {
    PreparedStatement makeStstment (Connection conn) throws SQLException; // 서버연결을 넘어서 쿼리문을 한방에 사용할 수 있도록 만든 인터페이스
}
