package com.gaogao.bussiness.user.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gaogao.bussiness.user.bo.User;
import com.gaogao.bussiness.user.service.UserService;
import com.gaogao.common.base.BaseController;
import com.gaogao.common.base.ResultMessage;
import com.gaogao.common.util.Md5Util;

/**
 * 用户服务端controller
 * 
 * @author gaohaiming 2014-8-20
 * 
 */
@RequestMapping("user")
@Controller
public class UserController extends BaseController {

	private UserService userService;

	/**
	 * 用户名是否可用
	 * 
	 * @param Port
	 */
	@RequestMapping("/isnameused")
	@ResponseBody
	public Object isNameUsed(HttpServletRequest request, String body) {
		ResultMessage result = null;
		User user = this.getParametersObject(request, User.class);
		user.setPwd(Md5Util.encryptByMd5(user.getPwd()));
		if (this.userService.queryIsUseNameExist(user.getUsername())) {
			result = ResultMessage.getSuccessResult("1", "用户名已存在");
		} else {
			result = ResultMessage.getSuccessResult("0", "用户名可用");
		}
		return result;
	}
	/**
	 * 用户注册
	 * 
	 * @param Port
	 */
	@RequestMapping("/register")
	@ResponseBody
	public Object register(HttpServletRequest request, String body) {
		ResultMessage result = null;
		User user = this.getParametersObject(request, User.class);
		user.setPwd(Md5Util.encryptByMd5(user.getPwd()));
		if (!this.userService.queryIsUseNameExist(user.getUsername())) {
			if (this.userService.addUser(user)) {
				result = ResultMessage.getSuccessResult("0", "注册成功");
				request.getSession().setAttribute("uerName", user.getUsername());
			}
		} else {
			result = ResultMessage.getSuccessResult("1", "用户名已存在");
		}
		return result;
	}

	/**
	 * 用户登录
	 * 
	 * @param Port
	 */
	@RequestMapping("/login")
	@ResponseBody
	public Object login(HttpServletRequest request) {
		ResultMessage result = null;
		User user = this.getParametersObject(request, User.class);
		if(this.userService.queryIsUseNameExist(user.getUsername())){
			String password = this.userService
					.getPasswordByName(user.getUsername());
			if (password.equals(Md5Util.encryptByMd5(user.getPwd()))) {
				request.getSession().setAttribute("uerName", user.getUsername());
				result = ResultMessage.getSuccessResult("0", "登录成功");
			} else {
				result = ResultMessage.getSuccessResult("1", "密码错误");
			}
		}else{
			result = ResultMessage.getSuccessResult("1", "账号不存在");
		}
		
		return result;
	}

	/**
	 * 用户信息修改
	 * 
	 * @param Port
	 */
	@RequestMapping("/update")
	@ResponseBody
	public Object update(HttpServletRequest request) {
		ResultMessage result = null;
		User user = this.getParametersObject(request, User.class);

		String userName = user.getUsername();
		if (null == userName && "".equals(userName)) {
			userName = (String) request.getSession().getAttribute("uerName");
			user.setUsername(userName);
		}

		String passWord = user.getPwd();
		if (null != passWord && !"".equals(passWord)) {
			user.setPwd(Md5Util.encryptByMd5(user.getPwd()));
		}

		if (this.userService.updateUser(user)) {
			result = ResultMessage.getSuccessResult("0", "修改成功");
		} else {
			result = ResultMessage.getSuccessResult("1", "修改失败");
		}
		return result;
	}

	/**
	 * @return the userService
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * @param userService
	 *            the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}