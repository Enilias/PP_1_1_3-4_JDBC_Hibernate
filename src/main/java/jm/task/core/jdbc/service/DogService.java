package jm.task.core.jdbc.service;

public interface DogService {
    void createDogTable();

    void saveDog(String name, byte age);
    public void dropDogTable();
    void cleanDogTable();
}
