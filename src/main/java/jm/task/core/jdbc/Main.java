package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("John", "Doe", (byte) 25);

        User user2 = new User("Jane", "Smith", (byte) 30);
        User user3 = new User("David", "Johnson", (byte) 35);
        User user4 = new User("Sarah", "Williams", (byte) 28);

        UserService userService = new UserServiceImpl();
        userService.createUsersTable();

        userService.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        userService.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        userService.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        userService.saveUser(user4.getName(), user4.getLastName(), user4.getAge());

        List<User> list = userService.getAllUsers();
        for (User user : list) {
            System.out.println(user);
        }

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}