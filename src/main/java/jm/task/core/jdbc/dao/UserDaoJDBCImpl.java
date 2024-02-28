package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.Dog;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoJDBCImpl implements UserDao {
    private static final Connection connection = Util.getConnection();

    public UserDaoJDBCImpl() {

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


    public void createUsersTable() {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS user(id BIGINT PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(50),  lastName  VARCHAR(50) NOT NULL , age TINYINT CHECK(age>-1));");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createCommunicationTables() {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS  communication_tables (" +
                    "    user_id BIGINT,\n" +
                    "    dog_id BIGINT,\n" +
                    "    PRIMARY KEY (user_id, dog_id)," +
                    "    FOREIGN KEY (user_id) REFERENCES user(id)," +
                    "    FOREIGN KEY (dog_id) REFERENCES dog(id)" +
                    ");");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropCommunicationTables() {
        try (Statement statement = connection.createStatement()) {
            statement.execute("DROP TABLE IF EXISTS communication_tables");
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

    public void saveUserAndDog(String name, String lastName, byte age, List<Dog> dogs) {
        try {
            PreparedStatement psUser = connection
                    .prepareStatement("INSERT INTO user(name, lastName, age) VALUES (?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            psUser.setString(1, name);
            psUser.setString(2, lastName);
            psUser.setByte(3, age);
            psUser.executeUpdate();

            ResultSet rsUser = psUser.getGeneratedKeys();
            rsUser.next();
            Long userId = rsUser.getLong(1);

            for (Dog dog : dogs) {
                PreparedStatement psDog = connection
                        .prepareStatement("INSERT INTO dog(name, age, user_id) VALUES (?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
                psDog.setString(1, dog.getName());
                psDog.setByte(2, dog.getAge());
                psDog.setLong(3, userId);
                psDog.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.printf("User с именем – %s и его собака добавлены в базу данных\n", name);
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
        Map<Long, Dog> dogMap = new HashMap<>();
        try (Statement statement1 = connection.createStatement();
             Statement statement2 = connection.createStatement()) {
            ResultSet resultUserSet = statement1.executeQuery("SELECT * FROM pre_project.user;");
            ResultSet resultDogSet = statement2.executeQuery("SELECT * FROM pre_project.dog;");
            while (resultUserSet.next()) {
                User user;
                user = new User(resultUserSet.getLong("id"),
                        resultUserSet.getString("name"),
                        resultUserSet.getString("lastName"),
                        resultUserSet.getByte("age"),
                        new ArrayList<>());

                while (resultDogSet.next()) {
                    dogMap.put(resultDogSet.getLong("user_id"
                    ), new Dog(resultDogSet.getLong("id"),
                            resultDogSet.getString("name"),
                            resultDogSet.getByte("age")));
                }

                dogMap.get(resultUserSet.getLong("id")).setUsers(user);

                 user.getDogs().add(dogMap.get(resultUserSet.getLong("id")));

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }


    public void cleanUsersTable() {
        try (Statement statement = connection.createStatement()) {
            statement.execute("TRUNCATE TABLE user");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cleanCommunicationTables() {
        try (Statement statement = connection.createStatement()) {
            statement.execute("TRUNCATE TABLE communication_tables");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
