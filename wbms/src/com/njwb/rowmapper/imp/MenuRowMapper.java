package com.njwb.rowmapper.imp;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.njwb.entity.Menu;
import com.njwb.rowmapper.RowMapper;

public class MenuRowMapper implements RowMapper {
	Logger log = Logger.getLogger(MenuRowMapper.class);

	public Object getMapRow(ResultSet rs) {
		Menu menu = new Menu();
		try {
			menu.setMenuId(rs.getInt(1));
			menu.setMenuName(rs.getString(2));
			menu.setMenuHrefUrl(rs.getString(3));
			menu.setParentId(rs.getInt(4));
		} catch (SQLException e) {
			log.error("menuRowMapper 出错");
			e.printStackTrace();
			

		}
		return menu;

	}
}

//
// menu_id int primary key,
// menu_name varchar(10),
// menu_href_url varchar(20),
// menu_parent_id int,