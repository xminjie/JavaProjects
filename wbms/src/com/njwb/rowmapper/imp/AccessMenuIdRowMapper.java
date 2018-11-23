package com.njwb.rowmapper.imp;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.njwb.rowmapper.RowMapper;

public class AccessMenuIdRowMapper implements RowMapper {

	public Object getMapRow(ResultSet rs) {
		try {
			return (Integer)rs.getInt(1);
		} catch (SQLException e) {
//			获取可用权限菜单失败
			e.printStackTrace();
		}
		return null;
	}

}
