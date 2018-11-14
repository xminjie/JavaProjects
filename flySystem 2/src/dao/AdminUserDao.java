package dao;

import entity.AdminUser;

public interface AdminUserDao {
    AdminUser login(String account, String password);
}
