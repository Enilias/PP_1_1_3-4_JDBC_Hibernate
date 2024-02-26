package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.DogDao;
import jm.task.core.jdbc.dao.DogDaoJDBCImpl;
import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

public class DogServiceImpl implements DogService {
    private final DogDao dogDao = new DogDaoJDBCImpl();

    @Override
    public void createDogTable() {
        dogDao.createDogTable();
    }

    @Override
    public void saveDog(String name, byte age) {

    }
}
