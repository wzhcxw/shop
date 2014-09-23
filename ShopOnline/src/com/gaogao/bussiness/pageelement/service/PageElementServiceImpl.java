package com.gaogao.bussiness.pageelement.service;

import com.gaogao.bussiness.user.bo.User;
import com.gaogao.bussiness.user.dao.UserDao;

/**
 * 用户服务层实现
 * 
 * @author gaohaiming 2014-8-20
 * 
 */
public class PageElementServiceImpl implements PageElementService {

	private UserDao userDao;

	/**
	 * @return the userDao
	 */
	public synchronized UserDao getUserDao() {
		return userDao;
	}

	/**
	 * @param userDao
	 *            the userDao to set
	 */
	public synchronized void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean addUser(User user) {

		return this.userDao.addUser(user);
	}

	@Override
	public boolean queryIsUseNameExist(String userName) {
		
		return this.userDao.queryIsUseNameExist(userName);
	}

	@Override
	public String getPasswordByName(String userName) {
		return this.userDao.getPasswordByName(userName);
	}

	@Override
	public boolean updateUser(User user) {
		return this.userDao.updateUser(user);
	}
}
