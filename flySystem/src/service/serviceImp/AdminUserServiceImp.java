package service.serviceImp;

import dao.AdminUserDao;
import entity.AdminUser;
import factory.ObjectFactory;

public class AdminUserServiceImp implements service.AdminUserService {
    @Override
    public AdminUser login(String account, String password) {
        AdminUserDao adminUserDao = (AdminUserDao) ObjectFactory.getObject("AdminUserDaoImp");
        return adminUserDao.login(account, password);
    }
}
