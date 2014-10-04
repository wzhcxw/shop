package com.gaogao.bussiness.user.bo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class NewsMapper implements RowMapper<News> {

	@Override
	public News mapRow(ResultSet rs, int rowNum) throws SQLException {

		News news = new News();
		news.setTitle(rs.getString("title"));
		news.setSeconduiid(rs.getString("seconduiid"));
		news.setUiid(rs.getString("uiid"));
		news.setContent(rs.getString("content"));
		news.setSort(rs.getString("sort"));
		news.setDate(rs.getString("date"));
		news.setTitleImage(rs.getString("titleimage"));
		return news;

	}

}