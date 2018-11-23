package com.njwb.service.imp;

import java.util.List;

import com.njwb.dao.UserDao;
import com.njwb.dao.imp.UserDaoImp;
import com.njwb.entity.Menu;
import com.njwb.entity.User;
import com.njwb.service.LoginService;

public class LoginServiceImp implements LoginService {
	UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User loginQuery(String account, String passwd) {

		return userDao.queryByAccountAndPasswd(account, passwd);
	}

	public List<Menu> queryMenuListByRoleId(Integer roleId) {
		List<Menu> menulist;

		menulist = userDao.queryFaMenuByRoleId(roleId);

		for (Menu faMenu : menulist) {
			faMenu.setSonMenu(userDao.querySonMenuByFaMenuIdAndRoleId(faMenu
					.getMenuId(), roleId));
		}

		return menulist;

	}

	public boolean userAbleByAccount(String account) {
		// TODO Auto-generated method stub
		return userDao.userAbleByAccount(account);
	}

	public List<User> queryAllUser() {
		// 查所有用户
		return userDao.queryAllUser();
	}

	public User queryByaccount(String account) {
		// TODO Auto-generated method stub
		return userDao.queryByAccount(account);
	}

	public boolean uerRoleModify(String account, Integer roleId) {
		// TODO Auto-generated method stub
		return userDao.uerRoleModify(account, roleId);
	}

	public boolean modifyUserPasswd(String account, String password) {
		// TODO Auto-generated method stub
		return userDao.modifyUserPasswd(account, password);
	}
	
	
	public static void main(String[] args) {
		LoginServiceImp loginServiceImp = new LoginServiceImp();
		loginServiceImp.setUserDao(new UserDaoImp());
		System.out.println(loginServiceImp.queryMenuListByRoleId(2));
	}

	

}
