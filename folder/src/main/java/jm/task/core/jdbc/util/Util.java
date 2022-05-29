package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest?user=root&password=root&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "12q34w67";
    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Util() {

    }

    public static Connection getConnection() {
        return connection;
    }
}
