package com.njwb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

import com.njwb.entity.Role;
import com.njwb.service.RoleService;
import com.njwb.service.imp.RoleServiceImp;

public class RoleController {

	RoleService roleService;

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	//
	public String roles(HttpServletRequest request, HttpServletResponse response) {
		//
		List<Role> roleList = roleService.queryAllRole();
		request.setAttribute("roleList", roleList);

		return "success";
	}

	public String roleAdd(HttpServletRequest request, HttpServletResponse response) {
		
		
		String roleName = request.getParameter("roleName");
		
		if(!roleName.trim().equals("")){
			roleService.roleAdd(roleName);
		}
		return "success";
	}
	
	public String roleDelete(HttpServletRequest request, HttpServletResponse response) {
		Integer roleId = Integer.parseInt(request.getParameter("roleId"));
		roleService.roleDelete(roleId);
		return "success";
		
	}
	
	
	
	public String roleLook(HttpServletRequest request, HttpServletResponse response) {
		Integer roleId = Integer.parseInt(request.getParameter("roleId"));
		Role role = roleService.queryRoleByRoleId(roleId);
		request.setAttribute("role", role);
		return "success";
		
	}
	
	
	public String roleModify(HttpServletRequest request, HttpServletResponse response) {
		Integer roleId = Integer.parseInt(request.getParameter("roleId"));
		String[] checkedMenu = request.getParameterValues("checkedMenu");
		
		List<Integer> menuList = new ArrayList<Integer>();
		for(String menu: checkedMenu){
			menuList.add(Integer.parseInt(menu));
		}
		roleService.modifyRoleMenu(roleId, menuList);
		
		
		System.out.println(roleId);
		System.out.println(menuList);

		return "success";
		
	}
	 

}
