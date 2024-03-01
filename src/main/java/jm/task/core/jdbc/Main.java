package jm.task.core.jdbc;

import jm.task.core.jdbc.model.Dog;
import jm.task.core.jdbc.service.DogService;
import jm.task.core.jdbc.service.DogServiceImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
        DogService dogService = new DogServiceImpl();

        userService.createUsersTable();
        dogService.createDogTable();


        userService.saveUserAndDog("Eva", "A", 31, creationOfDogs("Laki", 0));
        userService.saveUserAndDog("Lina", "B", 32, creationOfDogs("Rex", 5));
        userService.saveUserAndDog("Sveta", "C", 33, creationOfDogs("Sam", 9));
        userService.saveUserAndDog("Hela", "D", 34, creationOfDogs("Orfi", 15));
        userService.saveUserAndDog("Oly", "E", 35, creationOfDogs("Helif", 23));



        System.out.println(userService.getAllUsers());


        dogService.cleanDogTable();
        dogService.dropDogTable();

        userService.cleanUsersTable();
        userService.dropUsersTable();





    }

    public static List<Dog> creationOfDogs(String string, int age) {
        List<Dog> dogs = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            dogs.add(new Dog(string + " " + i, (byte) (age + i)));
        }
        return dogs;
    }
}
