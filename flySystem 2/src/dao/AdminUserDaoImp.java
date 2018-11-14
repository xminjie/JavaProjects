package dao;

import entity.AdminUser;
import util.AdminUserRowMap;
import util.JDBCTemp;

import java.util.List;

public class AdminUserDaoImp implements AdminUserDao {
    private JDBCTemp jt = new JDBCTemp();

    @Override
    public AdminUser login(String account, String password) {
        String sql = "select * from adminUser " +
                "where account = ? and password = ?";
        List list = jt.Query(sql, new AdminUserRowMap(), account, password);
        if (list.size() != 0) {
            return (AdminUser) list.get(0);
        } else {
            return null;
        }
    }
}



