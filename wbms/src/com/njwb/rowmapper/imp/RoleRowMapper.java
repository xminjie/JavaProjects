package com.njwb.rowmapper.imp;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.njwb.entity.Role;
import com.njwb.rowmapper.RowMapper;

public class RoleRowMapper implements RowMapper {

	public Object getMapRow(ResultSet rs) {
		Role role = new Role();
		try {
			role.setRoleId(rs.getInt(1));
			role.setRoleName(rs.getString(2));
			role.setRoleCreateTime(rs.getDate(3));
			return role;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("rolerowmapper失败");
			e.printStackTrace();
		}
		
		
		return null;
	}
	
}
