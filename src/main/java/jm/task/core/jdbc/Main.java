package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static final UserService userService = new UserServiceImpl();
    public static final User user1 = new User("Даня", "Danya", (byte) 15);
    public static final User user2 = new User("Ваня", "Vanya", (byte) 20);
    public static final User user3 = new User("Саня", "Sanya", (byte) 30);
    public static final User user4 = new User("Гордая Лань", "Lani Gordaya", (byte) 100);

    public static void main(String[] args) {
        userService.createUsersTable();
        System.out.println("Таблица создана");
        userService.saveUser(user1.name(), user1.lastName(), user1.age());
        System.out.println("User с именем – " + user1.name() + " добавлен в базу данных");
        userService.saveUser(user2.name(), user2.lastName(), user2.age());
        System.out.println("User с именем – " + user2.name() + " добавлен в базу данных");
        userService.saveUser(user3.name(), user3.lastName(), user3.age());
        System.out.println("User с именем – " + user3.name() + " добавлен в базу данных");
        userService.saveUser(user4.name(), user4.lastName(), user4.age());
        System.out.println("User с именем – " + user4.name() + " добавлена в базу данных");
        userService.getAllUsers().forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
