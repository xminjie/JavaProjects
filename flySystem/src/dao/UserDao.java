package dao;

import entity.User;

public interface UserDao {
    User UserRegister(User user);

    User UserRegisterCheck(User user);

    User UserLogin(String account, String password);
}
