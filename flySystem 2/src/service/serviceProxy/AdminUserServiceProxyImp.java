package service.serviceProxy;

import entity.AdminUser;
import factory.ObjectFactory;
import service.AdminUserService;
import service.serviceImp.AdminUserServiceImp;
import transaction.TransactionImp;

public class AdminUserServiceProxyImp implements AdminUserService {
    @Override
    public AdminUser login(String account, String password) {
        AdminUserServiceImp adminUserServiceImp = (AdminUserServiceImp) ObjectFactory.getObject("AdminUserServiceImp");
        TransactionImp transaction = (TransactionImp) ObjectFactory.getObject("TransactionImp");
        AdminUser u = null;
        try {
            transaction.begin();
            u = adminUserServiceImp.login(account, password);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return u;
    }
}
