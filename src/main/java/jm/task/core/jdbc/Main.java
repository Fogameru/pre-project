package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static final UserService userService = new UserServiceImpl();
    public static final User user1 = new User("Даня", "Danya", (byte) 15);
    public static final User user2 = new User("Ваня", "Vanya", (byte) 20);
    public static final User user3 = new User("Саня", "Sanya", (byte) 30);
    public static final User user4 = new User("Гордая Лань VersionHiberNate", "Lani Gordaya VersionHiberNate", (byte) 100);

    public static void main(String[] args) {
        userService.createUsersTable();
        System.out.println("Таблица создана");
        userService.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        System.out.println("User с именем – " + user1.getName() + " добавлен в базу данных");
        userService.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        System.out.println("User с именем – " + user2.getName() + " добавлен в базу данных");
        userService.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        System.out.println("User с именем – " + user3.getName() + " добавлен в базу данных");
        userService.saveUser(user4.getName(), user4.getLastName(), user4.getAge());
        System.out.println("User с именем – " + user4.getName() + " добавлена в базу данных");
        userService.getAllUsers().forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
