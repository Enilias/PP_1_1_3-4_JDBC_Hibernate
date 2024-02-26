package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.Dog;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private static final Connection connection = Util.getConnection();

    public UserDaoJDBCImpl() {

    }

    public void test() {
        try (Statement statement = connection.createStatement()) {
            // statement.execute("ALTER TABLE user ADD dogs varchar(255);");
            // statement.execute("ALTER TABLE user DROP COLUMN dogs");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void test2() {
        try (Statement statement = connection.createStatement()) {
            // statement.execute("ALTER TABLE user ADD dogs varchar(255);");
            // statement.execute("ALTER TABLE user DROP COLUMN dogs");
            // statement.execute("SELECT * FROM user JOIN dog ON user ")


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Long id, String name, String lastName, byte age) {
        try (PreparedStatement ps = connection
                .prepareStatement("UPDATE user SET name = ?, lastName = ?, age = ? WHERE id = ?;")) {
            ps.setString(1, name);
            ps.setString(2, lastName);
            ps.setByte(3, age);
            ps.setLong(4, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<User> UniqueValue() {
        List<User> userList = null;
        try (Statement statement = connection.createStatement()) {
            userList = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery("SELECT DISTINCT name,lastname,age FROM user;");
            while (resultSet.next()) {
                userList.add(new User(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastName"),
                        resultSet.getByte("age")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void createUsersTable() {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS user(id BIGINT PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(50), lastName VARCHAR(50), age TINYINT);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try (Statement statement = connection.createStatement()) {
            statement.execute("DROP TABLE IF EXISTS user");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (PreparedStatement ps = connection
                .prepareStatement("INSERT INTO user(name, lastName, age) VALUES (?, ?, ?);")) {
            ps.setString(1, name);
            ps.setString(2, lastName);
            ps.setByte(3, age);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.printf("User с именем – %s добавлен в базу данных\n", name);
    }

    public void saveUserAndDog(String name, String lastName, byte age, String dogName, byte dogAge) {
        try {
            // Сначала добавляем пользователя
            PreparedStatement psUser = connection
                    .prepareStatement("INSERT INTO user(name, lastName, age) VALUES (?, ?, ?);");
            psUser.setString(1, name);
            psUser.setString(2, lastName);
            psUser.setByte(3, age);
            psUser.executeUpdate();

            // Получаем ID только что добавленного пользователя

           // long userId = getAllUsers().get(getAllUsers().size()-1).getId();

            // Теперь добавляем собаку, связанную с этим пользователем
            PreparedStatement psDog = connection
                    .prepareStatement("INSERT INTO dog(name, age) VALUES (?, ?);");
            psDog.setString(1, dogName);
            psDog.setByte(2, dogAge);
            //psDog.setLong(3, userId);
            psDog.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.printf("User с именем – %s добавлен в базу данных\n", name);
    }


    public void removeUserById(long id) {
        try (PreparedStatement ps = connection.prepareStatement("DELETE FROM user WHERE id = ?")) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM pre_project.user;");
            while (resultSet.next()) {
                userList.add(new User(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastName"),
                        resultSet.getByte("age")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
    private List<Dog> getDogsForUser(Long userId) {
        List<Dog> dogs = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM dog WHERE user_id = ?")) {
            ps.setLong(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dogs.add(new Dog(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("breed"),
                        rs.getLong("user_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dogs;
    }

    public void cleanUsersTable() {
        try (Statement statement = connection.createStatement()) {
            statement.execute("TRUNCATE TABLE user");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
