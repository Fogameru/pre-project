package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    void addUser(User user);

    void updateUser(User user);

    User getUser(int id);

    void deleteUser(int id);
}
