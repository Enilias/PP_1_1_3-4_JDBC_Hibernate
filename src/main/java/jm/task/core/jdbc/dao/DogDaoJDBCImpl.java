package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DogDaoJDBCImpl implements DogDao {
    private static final Connection connection = Util.getConnection();

    @Override
    public void createDogTable() {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS dog(id BIGINT PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(50), age TINYINT, user_id BIGINT," +
                    "FOREIGN KEY (user_id) REFERENCES user(id));");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void dropDogTable() {
        try (Statement statement = connection.createStatement()) {
            statement.execute("DROP TABLE IF EXISTS dog");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveDog(String name, byte age, long user_id) {
        try (PreparedStatement ps = connection
                .prepareStatement("INSERT INTO dog(name, age) VALUES (?, ?);")) {
            ps.setString(1, name);
            ps.setByte(2, age);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.printf("Dog с именем – %s добавлен в базу данных\n", name);
    }
    public void cleanUsersTable() {
        try (Statement statement = connection.createStatement()) {
            statement.execute("TRUNCATE TABLE dog");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
