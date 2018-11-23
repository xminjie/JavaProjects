package com.njwb.rowmapper;

import java.sql.ResultSet;

public interface RowMapper {
	public Object getMapRow(ResultSet rs); 
}
