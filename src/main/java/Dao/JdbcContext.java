package Dao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcContext {
    private DataSource dataSource;
    public JdbcContext(DataSource dataSource){ // 클래스에서 conneticon을 받은 후 서버랑 연결된 상태에서
        this.dataSource = dataSource;
    }
    public void jdbcContextWithStatementStrategy(StatmentStrategy statmentStrategy) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
// 쿼리문을 작성하기 위해서 datasource를 받아 conn을 만들어서 쿼리문을 실행한다
        try{
            conn = dataSource.getConnection();
            ps = statmentStrategy.makeStstment(conn);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if(ps != null) {
                try {
                    ps.close();
                } catch(SQLException e) {
                }
            }
            if( conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }
}
