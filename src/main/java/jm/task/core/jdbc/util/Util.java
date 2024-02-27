package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    // реализуйте настройку соеденения с БД
    private static Connection connection;
    private static final String url1 = "jdbc:mysql://localhost:3306/pre_project";
    private static final String url2 = "jdbc:postgresql://localhost:5432/pre_project";

    private static final String userName = "root";
    private static final String password = "enias";

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager
                        .getConnection(url1, userName, password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Properties properties = new Properties();
            properties.setProperty(Environment.URL, url1);
            properties.setProperty(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
            properties.setProperty(Environment.USER, userName);
            properties.setProperty(Environment.PASS, password);
            sessionFactory = new Configuration()
                    .addProperties(properties)
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
        }
        return sessionFactory;
    }
}
