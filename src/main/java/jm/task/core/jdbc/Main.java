package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;


public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Lina","A", (byte) 1);
        userService.saveUser("Olya","B", (byte) 2);
        userService.saveUser("Ai","C", (byte) 3);
        userService.saveUser("Vika","D", (byte) 4);

        System.out.println(userService.getAllUsers());

        userService.cleanUsersTable();

        userService.dropUsersTable();

        Util.closeSessionFactory();

        //Util.closeConnection();



    }
}
