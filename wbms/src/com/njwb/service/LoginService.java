package com.njwb.service;

import java.util.List;

import com.njwb.entity.Menu;
import com.njwb.entity.User;

public interface LoginService {
	User loginQuery(String account, String passwd);

	User queryByaccount(String account);

	List<Menu> queryMenuListByRoleId(Integer roleId);

	// 禁用启用账户
	boolean userAbleByAccount(String account);

	List<User> queryAllUser();

	boolean uerRoleModify(String account, Integer roleId);
	
	boolean modifyUserPasswd(String account, String password);

}
