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
                    "name VARCHAR(50), age TINYINT);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveDog(String name, byte age, long user_id) {
        try (PreparedStatement ps = connection
                .prepareStatement("INSERT INTO user(name, age, user_id) VALUES (?, ?, ?);")) {
            ps.setString(1, name);
            ps.setByte(2, age);
            ps.setLong(3, user_id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.printf("User с именем – %s добавлен в базу данных\n", name);
    }
}
