package com.njwb.service.imp;

 import java.util.HashMap;
import java.util.List;

import com.njwb.dao.RoleDao;
import com.njwb.dao.imp.RoleDaoImp;
import com.njwb.dao.imp.UserDaoImp;
import com.njwb.entity.Menu;
import com.njwb.entity.Role;
import com.njwb.service.LoginService;
import com.njwb.service.RoleService;

public class RoleServiceImp implements RoleService {
	
	LoginService loginService;
	RoleDao roleDao;
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public List<Role> queryAllRole() {
		 
		return roleDao.queryAllRole();
	}

	public Role queryRoleByRoleId(Integer roleId) {
		
		//查询单个role时候，把他可获得的菜单也查到
		
		Role role = roleDao.queryRoleByRoleId(roleId);
		
		
		List<Integer> menuIdList =
			roleDao.queryAllAccessMenuIdByRoleId(roleId);
//		
		HashMap<Long, Integer> accessMenuMap = new HashMap<Long, Integer>();
		for(Integer menuId: menuIdList) {
			accessMenuMap.put(new Long(menuId), 1);
		}
		role.setAccessMenu(accessMenuMap);
		
		return role;
	}

	public boolean roleAdd(String roleName) {
		// TODO Auto-generated method stub
		return roleDao.roleAdd(roleName);
	}

	public boolean roleDelete(Integer roleId) {
		// TODO Auto-generated method stub
		return roleDao.roleDelete(roleId);
	}

	public boolean roleNameModify(Integer roleId, String roleName) {
		// TODO Auto-generated method stub
		return roleDao.roleNameModify(roleId, roleName);
	}
	
	public boolean modifyRoleMenu(Integer roleId, List<Integer> menuList) {
		// TODO Auto-generated method stub
		
		int menu1 = 0, menu2 =0, menu3  =0;
		for(Integer menuId:menuList){
			if(menuId / 10 == 1) menu1 = 1;
			if(menuId / 10 == 2) menu2 = 2;
			if(menuId / 10 == 3) menu3 = 3;
		}
		
		if(menu1 == 1){
			menuList.add(1);
		}
		if(menu2 == 2){
			menuList.add(2);
		}
		if(menu3 == 3){
			menuList.add(3);
		}
		
		
		
		
		return roleDao.modifyRoleMenu(roleId, menuList);
	}
	
	
	public static void main(String[] args) {
		
		RoleDaoImp roleDaoImp = new RoleDaoImp();
		RoleServiceImp roleServiceImp = new RoleServiceImp();
		roleServiceImp.setRoleDao(roleDaoImp);
		System.out.println(roleServiceImp.queryRoleByRoleId(1));
		
 		
	}
	
	

}
