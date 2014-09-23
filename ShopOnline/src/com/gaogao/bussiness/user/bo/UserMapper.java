package com.gaogao.bussiness.user.bo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;




/**
 * 基本终端映射类
 * 
 * @author gaohaiming 2013-03-18
 * 
 */
public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {

		User user = new User();

		user.setUsername(rs.getString("username"));
		user.setPwd(rs.getString("password"));
		user.setPhonenumber(rs.getString("phonenumber"));
		user.setUuid(rs.getString("uuid"));
		return user;

	}

}
