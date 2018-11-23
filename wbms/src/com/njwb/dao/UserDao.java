package com.njwb.dao;

import java.util.List;

import com.njwb.entity.Menu;
import com.njwb.entity.User;
 
  
public interface UserDao {
	//登陆时查询账户和密码
	User queryByAccountAndPasswd(String account, String passwd);
	
	//查询父菜单
	List<Menu> queryFaMenuByRoleId(Integer roleId);
	
	//查询字菜单
	List<Menu> querySonMenuByFaMenuIdAndRoleId(Integer faMenuId, Integer roleId);
	
	// 添加用户
	 boolean addUserByAccountAndPasswd(String account, String passwd);
	 
	 //删除用户
	 
	 boolean deleteUserByAccount(String acccount);
	 
	 //禁用启用账户
	 boolean userAbleByAccount(String account);

	List<User> queryAllUser();
	
	User queryByAccount(String  account);
	
	//修改用户的角色
	boolean uerRoleModify(String account, Integer roleId);
	
	boolean modifyUserPasswd(String account, String password);
	 
	 
	
}
