package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.Dog;
import jm.task.core.jdbc.model.User;

import java.util.List;

public interface UserDao {
    void createUsersTable();

    void dropUsersTable();

    void saveUser(String name, String lastName, byte age);

    void removeUserById(long id);

    List<User> getAllUsers();

    void cleanUsersTable();
    void cleanCommunicationTables();

    void update(Long id, String name, String lastName, byte age);

    void saveUserAndDog(String name, String lastName, byte age, List<Dog> dogs);

    void createCommunicationTables();

    void dropCommunicationTables();
}
