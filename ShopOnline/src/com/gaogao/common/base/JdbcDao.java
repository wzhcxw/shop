package com.gaogao.common.base;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * jdbcDao父类已注入JdbcTemplate
 * 
 * @author gaohaiming 2013-5-24
 * 
 */
public class JdbcDao {
	private JdbcTemplate jdbcTemplate;

	/**
	 * 更新数据
	 * 
	 * @param sql
	 */
	public boolean update(String sql) {
		System.out.println(sql);
		int result = jdbcTemplate.update(sql);
		boolean isSuccessful = false;
		if (result > 0) {
			isSuccessful = true;
		}

		return isSuccessful;
	}

	/**
	 * 对象列表查询
	 * 
	 * @param sql
	 * @param rowMapper
	 * @return
	 */
	public <T> List<T> query(String sql, RowMapper<T> rowMapper) {
		System.out.println(sql);

		return jdbcTemplate.query(sql, rowMapper);
	}

	/**
	 * 单个对象查询
	 * 
	 * @param sql
	 * @param rowMapper
	 * @return
	 */
	public <T> T queryForObject(String sql, RowMapper<T> rowMapper) {
		return jdbcTemplate.queryForObject(sql, rowMapper);
	}

	/**
	 * 根据类型查询
	 * 
	 * @param sql
	 * @param requiredType
	 * @return
	 */
	public <T> T queryForObject(String sql, Class<T> requiredType) {
		return this.jdbcTemplate.queryForObject(sql, requiredType);
	}

	/**
	 * 数量查询
	 * 
	 * @param sql
	 * @return
	 */
	public int queryForInt(String sql) {
		System.out.println(sql);
		return jdbcTemplate.queryForInt(sql);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
