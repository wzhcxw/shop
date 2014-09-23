package com.gaogao.bussiness.pageelement.service;

import com.gaogao.bussiness.user.bo.User;

/**
 * 用户服务层接口
 * 
 * @author gaohaiming 2014-8-20
 * 
 */
public interface PageElementService {
	/**
	 * 用户注册
	 * 
	 * @param user
	 * @return
	 */
	public boolean addUser(User user);

	/**
	 * 查询用户名是否存在
	 * 
	 * @param userName
	 * @return
	 */
	public boolean queryIsUseNameExist(String userName);

	/**
	 * 根据用户名获取用户信息
	 * 
	 * @param user
	 * @return
	 */
	public String getPasswordByName(String userName);

	/**
	 * 修改用户信息
	 * 
	 * @param user
	 * @return
	 */
	public boolean updateUser(User user);
}
