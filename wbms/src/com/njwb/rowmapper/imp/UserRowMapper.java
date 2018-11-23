package com.njwb.rowmapper.imp;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.njwb.entity.User;
import com.njwb.rowmapper.RowMapper;
 
public class UserRowMapper  implements RowMapper{

	public Object getMapRow(ResultSet rs) {
		User user = new User();
		
		try {
			user.setId(rs.getInt(1));
			user.setAccount(rs.getString(2));
			user.setPasswd(rs.getString(3));
			user.setName(rs.getString(4));
			user.setRoleId(rs.getInt(5));
			user.setStatus(rs.getInt(6));
			user.setCreateTime(rs.getDate(7));
			user.setRoleName(rs.getString(8));
			return user;
		} catch (SQLException e) {
			System.out.println("userrowmapper转出错");
			e.printStackTrace();
		}
		return null;
	}
	
}
