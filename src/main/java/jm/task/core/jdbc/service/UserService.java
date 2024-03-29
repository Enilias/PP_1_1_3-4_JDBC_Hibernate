package jm.task.core.jdbc.service;

import jm.task.core.jdbc.model.Dog;
import jm.task.core.jdbc.model.User;

import java.util.List;

public interface UserService {
    void createUsersTable();
    void createCommunicationTables();

    void dropUsersTable();
    void dropCommunicationTables();

    void saveUser( String name, String lastName, byte age);

    void removeUserById(long id);

    List<User> getAllUsers();

    void cleanUsersTable();
    void cleanCommunicationTables();

    public void update(Long id, String name, String lastName, byte age);
    public void saveUserAndDog(String name, String lastName, int age, String dogName, int dogAge);
}
