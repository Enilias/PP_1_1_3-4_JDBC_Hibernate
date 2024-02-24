package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();
        // userService.test();

//        userService.saveUser("Lina","A", (byte) 1);
//        userService.saveUser("Olya","B", (byte) 2);
//        userService.saveUser("Ai","C", (byte) 3);
//        userService.saveUser("Vika","D", (byte) 4);
        userService.update(1L, "WQDWCFWDCF", "IKJIK", (byte) 5);

        System.out.println(userService.getAllUsers());

//        userService.cleanUsersTable();
//        userService.dropUsersTable();

        //Util.closeConnection();


    }
}
