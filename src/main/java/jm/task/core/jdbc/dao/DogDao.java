package jm.task.core.jdbc.dao;

import java.sql.SQLException;
import java.sql.Statement;


public interface DogDao {
    void createDogTable();

    void saveDog(String name, byte age, long user_id);
    void cleanUsersTable();

    public void dropDogTable();

}
