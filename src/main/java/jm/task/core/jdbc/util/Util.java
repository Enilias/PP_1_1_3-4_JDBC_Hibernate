package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    public static Connection getConnection() {
        Connection connection;
        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/pre_project", "root", "enias");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

}
