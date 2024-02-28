package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.DogDaoJDBCImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.Dog;
import jm.task.core.jdbc.service.DogService;
import jm.task.core.jdbc.service.DogServiceImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();
        DogService dogService = new DogServiceImpl();

        userService.createUsersTable();
        dogService.createDogTable();
        // userService.createCommunicationTables();

//        userService.saveUser("Lina","A", (byte) 1);
//        userService.saveUser("Olya","B", (byte) 2);
//        userService.saveUser("Ai","C", (byte) 3);
//        userService.saveUser("Vika","D", (byte) 4);
//        userService.update(1L, "WQDWCFWDCF", "IKJIK", (byte) 5);


        userService.saveUserAndDog("Eva", "A", 31, creationOfDogs("Laki", 0));
        userService.saveUserAndDog("Lina", "B", 32, creationOfDogs("Rex", 5));
        userService.saveUserAndDog("Sveta", "C", 33, creationOfDogs("Sam", 9));
        userService.saveUserAndDog("Hela", "D", 34, creationOfDogs("Orfi", 15));
        userService.saveUserAndDog("Oly", "E", 35, creationOfDogs("Helif", 23));

//        for (int i = 0; i < 1000; i++) {
//            userService.saveUserAndDog("Eva", "A", 31, "BOBIK", 1);
//            userService.saveUserAndDog("Lina", "B", 32, "Rex", 1);
//            userService.saveUserAndDog("Sveta", "C", 33, "Tem", 2);
//            userService.saveUserAndDog("Hela", "D", 34, "Her", 3);
//            userService.saveUserAndDog("Oly", "E", 35, "Piny", 4);
//
//        }


        System.out.println(userService.getAllUsers());

        // userService.cleanCommunicationTables();
//        userService.dropCommunicationTables();

        dogService.cleanDogTable();
        dogService.dropDogTable();

        userService.cleanUsersTable();
        userService.dropUsersTable();


        //userService.dropCommunicationTables();
        //dogService.dropDogTable();
        //Util.closeConnection();

        //Util.closeConnection();


    }

    public static List<Dog> creationOfDogs(String string, int age) {
        List<Dog> dogs = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            dogs.add(new Dog(string + " " + i, (byte) (age + i)));
        }
        return dogs;
    }
}
