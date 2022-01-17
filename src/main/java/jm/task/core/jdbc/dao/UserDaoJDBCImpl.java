package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try {
            Util.getConnection().createStatement().execute("CREATE TABLE user(id BIGINT PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(50), lastName VARCHAR(50), age TINYINT);");
        } catch (SQLException ignored) {

        }
    }

    public void dropUsersTable() {
        try {
            Util.getConnection().createStatement().execute("DROP TABLE user");
        } catch (SQLException ignored) {

        }
    }

    public void saveUser(String name, String lastName, byte age) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO user(name, lastName, age) VALUES (").append("'")
                .append(name).append("', ").append("'").append(lastName).append("', ").append(age).append(");");
        try {
            Util.getConnection().createStatement().execute(String.valueOf(sb));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.printf("User с именем – %s добавлен в базу данных\n", name);
    }

    public void removeUserById(long id) {
        try {
            Util.getConnection().createStatement().execute("DELETE FROM user WHERE id = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try {
            ResultSet resultSet = Util.getConnection().createStatement().executeQuery("SELECT * FROM pre_project.user;");
            while (resultSet.next()) {
                userList.add(new User(resultSet.getString(2)
                        , resultSet.getString(3), resultSet.getByte(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void cleanUsersTable() {
        try {
            Util.getConnection().createStatement().execute("TRUNCATE TABLE user");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
