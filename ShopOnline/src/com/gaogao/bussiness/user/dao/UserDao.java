package com.gaogao.bussiness.user.dao;

import com.gaogao.bussiness.user.bo.User;

/**
 * 用户DAO层接口
 * 
 * @author gaohaiming 2014-8-20
 * 
 */
public interface UserDao {
	/**
	 * 添加用户
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
	 * 获取用户
	 * 
	 * @param username
	 * @return
	 */
	public User getUserByName(String userName);

	/**
	 * 获取用户的密码
	 * 
	 * @param userName
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
