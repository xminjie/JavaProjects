package service.serviceProxy;

import entity.User;
import factory.ObjectFactory;
import service.UserService;
import service.serviceImp.UserServiceImp;
import transaction.TransactionImp;

public class UserServiceProxyImp implements UserService {


    @Override
    public User login(String account, String password) {
        UserServiceImp userServiceImp = (UserServiceImp) ObjectFactory.getObject("UserServiceImp");
        TransactionImp tran = (TransactionImp) ObjectFactory.getObject("TransactionImp");
        User user = null;
        try {
            tran.begin();
            user = userServiceImp.login(account, password);
            tran.commit();
        } catch (Exception e) {
            tran.rollback();
        }
        return user;
    }

    @Override
    public User register(User user) {
        UserServiceImp userServiceImp = (UserServiceImp) ObjectFactory.getObject("UserServiceImp");
        TransactionImp tran = (TransactionImp) ObjectFactory.getObject("TransactionImp");
        User u = null;
        try {
            tran.begin();
            u = userServiceImp.register(user);
            tran.commit();
        } catch (Exception e) {
            tran.rollback();
        }
        return u;
    }

    public static void main(String[] args) {
//        User user = new User("fqq0dfq-", "123", "xiaoming", "3203231997101728", "0", "15715216140", "1624034635@qq.com", "南京");

        UserServiceProxyImp userServiceProxyImp= new UserServiceProxyImp();
//        System.out.println(userServiceProxyImp.regiest(user));


        System.out.println(userServiceProxyImp.login("aaa","123"));;

    }

}
