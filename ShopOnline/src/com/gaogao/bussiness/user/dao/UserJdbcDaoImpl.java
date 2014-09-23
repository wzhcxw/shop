package com.gaogao.bussiness.user.dao;

import com.gaogao.bussiness.user.bo.User;
import com.gaogao.bussiness.user.bo.UserMapper;
import com.gaogao.common.base.JdbcDao;

/**
 * 用户DAO层Jdbc方式实现
 * 
 * @author gaohaiming 2014-8-20
 * 
 */
public class UserJdbcDaoImpl extends JdbcDao implements UserDao {

	@Override
	public boolean addUser(User user) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into userinfo (username,pwd,phonenumber,uuid)values('");
		sql.append(user.getUsername());
		sql.append("','");
		sql.append(user.getPwd());
		sql.append("','");
		sql.append(user.getPhonenumber());
		sql.append("','");
		sql.append(user.getUuid());
		sql.append("')");
		return this.update(sql.toString());
	}

	@Override
	public boolean queryIsUseNameExist(String userName) {
		StringBuilder sql = new StringBuilder();
		sql.append("select count(1) from userinfo where username='");
		sql.append(userName);
		sql.append("'");
		int count = this.queryForInt(sql.toString());
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public User getUserByName(String userName) {
		StringBuilder sql = new StringBuilder();
		sql.append("select username,pwd,phonenumber,imei from userinfo where username='");
		sql.append(userName);
		sql.append("'");
		return this.queryForObject(sql.toString(), new UserMapper());
	}

	@Override
	public String getPasswordByName(String userName) {
		StringBuilder sql = new StringBuilder();
		sql.append("select pwd from userinfo where username='");
		sql.append(userName);
		sql.append("'");
		return this.queryForObject(sql.toString(), String.class);
	}

	@Override
	public boolean updateUser(User user) {
		StringBuilder sql = new StringBuilder();
		sql.append("update userinfo set ");

		String pwd = user.getPwd();
		if (null != pwd && !"".equals(pwd)) {
			sql.append("pwd='");
			sql.append(pwd);
			sql.append("',");
		}

		String phoneNumber = user.getPhonenumber();
		if (null != phoneNumber && !"".equals(phoneNumber)) {
			sql.append("phonenumber='");
			sql.append(phoneNumber);
			sql.append("',");
		}

		String imei = user.getUuid();
		if (null != imei && !"".equals(imei)) {
			sql.append("uuid='");
			sql.append(imei);
			sql.append("'");
		}
		String sqltemp = sql.toString();
		sqltemp = sqltemp.substring(0, sqltemp.length() - 1);
		sql.append(" where username='");
		sql.append(user.getUsername());
		sql.append("'");
		return this.update(sql.toString());
	}
}
