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
        UserDaoJDBCImpl.createCommunicationTables();
        // userService.test();

//        userService.saveUser("Lina","A", (byte) 1);
//        userService.saveUser("Olya","B", (byte) 2);
//        userService.saveUser("Ai","C", (byte) 3);
//        userService.saveUser("Vika","D", (byte) 4);
//        userService.update(1L, "WQDWCFWDCF", "IKJIK", (byte) 5);
        // userService.saveUserAndDog("Eli","l",(byte) 52,);
        userService.saveUserAndDog("DogHYNTER", "HAHAHA", 45, "REX12", 8);

        System.out.println(userService.getAllUsers());

        DogDaoJDBCImpl.cleanUsersTable();
        userService.cleanUsersTable();
        userService.dropUsersTable();
        dogService.dropDogTable();
        Util.closeConnection();

        //Util.closeConnection();


    }
}
