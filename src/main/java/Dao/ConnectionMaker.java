package Dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {
    public Connection makeConnection() throws ClassNotFoundException, SQLException;      // 연결 객체를 반환하는 인터페이스 구현
    }

