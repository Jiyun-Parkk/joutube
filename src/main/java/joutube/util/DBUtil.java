package main.java.joutube.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/";
    private static final String PASSWORD = "1234";
    private static final String DATABASE_NAME = "joutube";
    private static final String USER = "root";

    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASSWORD);
            return connection;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

}
