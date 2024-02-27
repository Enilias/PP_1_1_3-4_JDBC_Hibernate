package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.DogDaoJDBCImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.Dog;
import jm.task.core.jdbc.service.DogService;
import jm.task.core.jdbc.service.DogServiceImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;


public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();
        DogService dogService = new DogServiceImpl();

        userService.createUsersTable();
        dogService.createDogTable();
        userService.createCommunicationTables();
        // userService.test();

//        userService.saveUser("Lina","A", (byte) 1);
//        userService.saveUser("Olya","B", (byte) 2);
//        userService.saveUser("Ai","C", (byte) 3);
//        userService.saveUser("Vika","D", (byte) 4);
//        userService.update(1L, "WQDWCFWDCF", "IKJIK", (byte) 5);
        // userService.saveUserAndDog("Eli","l",(byte) 52,);
       //userService.saveUserAndDog("L1", "HAHAHA", 45, "L1", 45);
        userService.saveUserAndDog("DOGHANTER12", "DOGHANTER12", 32,"DOGHANTER12",32);

        System.out.println(userService.getAllUsers());

//        userService.cleanCommunicationTables();
//        userService.dropCommunicationTables();
//
//        userService.cleanUsersTable();
//        userService.dropUsersTable();
//
//        dogService.createDogTable();
//        dogService.dropDogTable();


        //userService.dropCommunicationTables();
        //dogService.dropDogTable();
        //Util.closeConnection();

        //Util.closeConnection();


    }
}
