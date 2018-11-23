package com.njwb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.njwb.entity.Role;
import com.njwb.entity.User;
import com.njwb.service.LoginService;
import com.njwb.service.RoleService;

public class UserController {

	Logger log = Logger.getLogger(UserController.class);

	LoginService loginService;
	RoleService roleService;
	
 
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
 
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public String userAble(HttpServletRequest request,
			HttpServletResponse response) {

		String account = request.getParameter("account");

		loginService.userAbleByAccount(account);

		return "success";

	}

	public String users(HttpServletRequest request, HttpServletResponse response) {

		List<User> userList = loginService.queryAllUser();
		request.setAttribute("userList", userList);
		log.info("所有账户" + userList);

		return "success";

	}
	
	public String userModify(HttpServletRequest request, HttpServletResponse response) {

		String account = request.getParameter("account");
		Integer roleId = Integer.parseInt(request.getParameter("roleId"));
		
		System.out.println(account + "------------------------------------------------");
		
		loginService.uerRoleModify(account, roleId);

		return "success";

	}
	
	public String userLook(HttpServletRequest request, HttpServletResponse response) {

		List<Role> rolelList =  roleService.queryAllRole();
		request.setAttribute("roleList", rolelList);
		
		
		String account = request.getParameter("account");
		User user = loginService.queryByaccount(account);
		request.setAttribute("user", user);

		return "success";

	}
	
	public String loginOut(HttpServletRequest request, HttpServletResponse response) {

		request.getSession().invalidate();

		return "success";

	}
	
	public String modifyUserPasswd(HttpServletRequest request, HttpServletResponse response) {
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		String account = loginUser.getAccount();
		String oldpasswd = request.getParameter("oldPassword"); 
		String newpasswd1 = request.getParameter("newPassword1");
		String newpasswd2 = request.getParameter("newPassword2");
		
		if(loginService.loginQuery(account, oldpasswd) != null && newpasswd1.equals(newpasswd2)){
			loginService.modifyUserPasswd(account, newpasswd2);
			return "success";
		}
		
		
		
		
		// TODO Auto-generated method stub
		return "false";
	}
	

}
