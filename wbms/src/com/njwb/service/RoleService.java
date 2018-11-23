package com.njwb.service;

import java.util.List;

import com.njwb.entity.Role;

public interface RoleService {
	// 查所有角色
	// 查单个角色
	// 删除角色
	// 更改角色
	// 添加角色

	boolean roleAdd(String roleName);

	boolean roleNameModify(Integer roleId, String roleName);

	boolean roleDelete(Integer roleId);

	List<Role> queryAllRole();

	Role queryRoleByRoleId(Integer roleId);
	
	boolean modifyRoleMenu(Integer roleId, List<Integer> menuList);


}
