package com.njwb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
import org.apache.log4j.Logger;

import com.njwb.entity.Menu;
import com.njwb.entity.User;
import com.njwb.service.LoginService;
import com.njwb.util.MakeCertPic;
 
public class LoginController {
	private Logger log = Logger.getLogger(LoginController.class);
	LoginService loginService;

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public void getCodeImg(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String sysCode = MakeCertPic.getCertPic(60, 20, response
				.getOutputStream());
		log.info("请求的验证码:" + sysCode);
		request.getSession().setAttribute("sysCode", sysCode);
		// 短信验证码,必须携带手机号码作为参数
		// 先随机生成4位数,保存在session中, 套用短信模版,调用短信接口 (短信网关)
	}

	public String login(HttpServletRequest resquest,
			HttpServletResponse response) {

		String account = resquest.getParameter("account");
		String passwd = resquest.getParameter("passwd");

		String userCode = resquest.getParameter("code");
		String sysCode = (String) resquest.getSession().getAttribute("sysCode");

		log.info("登陆account " + account);
		log.info("登陆passwd " + passwd);

		log.info("系统验证码 " + sysCode);
		log.info("用户验证码 " + userCode);

		// 暂时注释掉验证码

//		 if(userCode == null ||
//		 !userCode.toUpperCase().equals(sysCode.toUpperCase())){//大小写通用
//			 return "fail";
//		 }
				

		User u = loginService.loginQuery(account, passwd);
		System.out.println(resquest.getContextPath());
		if (u == null) {
			return "fail";

		} else {
			
			List<Menu> menuList = loginService.queryMenuListByRoleId(u.getRoleId());
			
			//设置菜单列表
			resquest.getSession().setAttribute("menuList", menuList);
			//设置登陆用户
			resquest.getSession().setAttribute("loginUser", u);
			return "success";
		}
	}
	public static void main(String[] args) {
		LoginController loginController = new LoginController();
		System.out.println(loginController.loginService.loginQuery("admin", "admin"));
	}
  
}
