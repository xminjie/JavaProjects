package util;

import entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMap implements RowMap{

    @Override
    public Object getRowmap(ResultSet res) {
        User user = new User();
        try {
            user.setAccount(res.getString("account"));
            user.setPassword(res.getString("password"));
            user.setName(res.getString("name"));
            user.setIdentityId(res.getString("identityId"));
            user.setSex(res.getString("sex"));
            user.setTel(res.getString("tel"));
            user.setEmail(res.getString("email"));
            user.setAddress(res.getString("address"));
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        return user;
    }
}
