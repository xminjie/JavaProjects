package service;

import entity.AdminUser;

public interface AdminUserService {
    AdminUser login(String account, String password);
}
