package jm.task.core.jdbc.dao;

public interface DogDao {
    void createDogTable();

    void saveDog(String name, byte age, long user_id);
    void cleanDogTable();

    public void dropDogTable();

}
