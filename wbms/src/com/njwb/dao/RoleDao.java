package com.njwb.dao;

import java.util.List;

import com.njwb.entity.Role;

public interface RoleDao {
	//角色的增删改查
	boolean roleAdd(String roleName);
	boolean roleNameModify(Integer roleId, String roleName);
	boolean roleDelete(Integer roleId);
	List<Role> queryAllRole();
	Role queryRoleByRoleId(Integer roleId);
	List<Integer> queryAllAccessMenuIdByRoleId(Integer roleId);
	
	boolean modifyRoleMenu(Integer roleId, List<Integer> menuList);
}
