package util;

import entity.AdminUser;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminUserRowMap implements RowMap{
    @Override
    public Object getRowmap(ResultSet res) {
        AdminUser adminUser = new AdminUser();
        try {
            adminUser.setAccount(res.getString("account"));
            adminUser.setPassword(res.getString("password"));
            adminUser.setName(res.getString("name"));
            adminUser.setIdentityId(res.getString("identityId"));
        } catch (SQLException e) {
            return null;
        }
        return adminUser;
    }
}
