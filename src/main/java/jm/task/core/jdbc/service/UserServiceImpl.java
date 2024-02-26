package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.Dog;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoJDBCImpl();

    public void createUsersTable() {
        userDao.createUsersTable();
    }

    public void dropUsersTable() {
        userDao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDao.saveUser(name, lastName, age);

    }

    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void cleanUsersTable() {
        userDao.cleanUsersTable();
    }

    @Override
    public void update(Long id, String name, String lastName, byte age) {
        userDao.update(id, name, lastName, age);
    }

    @Override
    public void saveUserAndDog(String name, String lastName, int age, String dogName, int dogAge) {
        if (age < 172 || dogAge < 172) {
            userDao.saveUserAndDog(name, lastName, (byte) age, dogName, (byte) dogAge);
        } else {
            System.out.println("Возрост не коректный");
        }
    }

    public void test() {
        userDao.test();
    }
}
