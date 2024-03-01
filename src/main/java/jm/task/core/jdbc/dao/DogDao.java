package jm.task.core.jdbc.dao;
@SuppressWarnings("unused")
public interface DogDao {
    void createDogTable();

    void saveDog(String name, byte age, long user_id);
    void cleanDogTable();

    void dropDogTable();

}
