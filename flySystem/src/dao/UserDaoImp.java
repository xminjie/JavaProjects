package dao;

import action.Who;
import entity.User;
import util.JDBCTemp;
import util.UserRowMap;

import java.util.List;

public class UserDaoImp implements UserDao {

    private JDBCTemp jt;

    {
        jt = new JDBCTemp();
    }

    @Override
    public User UserRegister(User user) {

        if (UserRegisterCheck(user) != null) {
            return null;
        }

        String sql = "insert into user (account,password,name,identityId,sex,tel,email,address)values ( " +
                "?, ?, ? ,?, ? ,? ,?, ? " +
                ") ";
        jt.update(sql, user.getAccount(), user.getPassword()
                , user.getName(), user.getIdentityId(), user.getSex()
                , user.getTel(), user.getEmail(), user.getAddress()
        );
//        System.out.println(user.getSex());
        return user;
    }

    @Override
    public User UserRegisterCheck(User user) {
        String sql = "select * from user where account = ? ";
        List u = jt.Query(sql, new UserRowMap(), user.getAccount());
        if (u.size() != 0) {
            return (User) u.get(0);
        } else {
            return null;
        }

    }

    @Override
    public User UserLogin(String account, String password) {
        String sql = "select * from user " +
                "where account = ? and password = ? ";
        List list = jt.Query(sql, new UserRowMap(), account, password);
        if (list.size() != 0) {
            return (User) list.get(0);
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Who.user = new User("aaa", "123", "xiaoming", "3203231997101728", "0", "15715216140", "1624034635@qq.com", "南京");

        UserDaoImp userDao = new UserDaoImp();
        User user = new User("aaa", "123", "xiaoming", "3203231997101728", "0", "15715216140", "1624034635@qq.com", "南京");
        userDao.UserRegister(user);
//        if (userDao.UserRegiestCheck(user) == null) {
//            System.out.println("avaible");
//        } else {
//            System.out.println("account exist");
//        }
//        ;


        System.out.println(userDao.UserLogin("aaa", "123"));




    }
}
