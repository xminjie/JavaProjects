package service.serviceImp;

import dao.UserDaoImp;
import entity.User;
import factory.ObjectFactory;
import service.UserService;

public class UserServiceImp implements UserService {
    @Override
    public User login(String account, String password) {
        UserDaoImp userDao = (UserDaoImp) ObjectFactory.getObject("UserDaoImp");
        return userDao.UserLogin(account, password);
    }

    @Override
    public User register(User user) {
        UserDaoImp userDaoImp = (UserDaoImp) ObjectFactory.getObject("UserDaoImp");
        if (userDaoImp.UserRegisterCheck(user) == null) {
            return userDaoImp.UserRegister(user);
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        User user = new User("t0030-", "123", "xiaoming", "3203231997101728", "0", "15715216140", "1624034635@qq.com", "南京");
        UserServiceImp userServiceImp = new UserServiceImp();
        System.out.println(userServiceImp.register(user));
    }

}
