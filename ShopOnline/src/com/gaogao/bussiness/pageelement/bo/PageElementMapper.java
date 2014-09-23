package com.gaogao.bussiness.pageelement.bo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;




/**
 * 基本终端映射类
 * 
 * @author gaohaiming 2013-03-18
 * 
 */
public class PageElementMapper implements RowMapper<PageElement> {

	@Override
	public PageElement mapRow(ResultSet rs, int rowNum) throws SQLException {

		PageElement user = new PageElement();

		user.setType(rs.getString("type"));
		user.setUiid(rs.getString("uiid"));
		user.setSort(rs.getString("sort"));
		user.setContent(rs.getString("content"));
		return user;

	}

}
