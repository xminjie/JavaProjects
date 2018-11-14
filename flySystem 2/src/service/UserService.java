package service;

import entity.User;

public interface UserService {
    User login(String account, String password);
    User register(User user);
}
