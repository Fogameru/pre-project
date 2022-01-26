package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL_BD = "jdbc:mysql://localhost:3306/test";
    public static final String USERNAME_BD = "root";
    public static final String PASSWORD_BD = "root";

    public static Connection getConnection() {
        try {
           Connection connection = DriverManager.getConnection(URL_BD, USERNAME_BD, PASSWORD_BD);
           return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
