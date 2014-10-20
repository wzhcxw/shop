package com.gaogao.bussiness.user.bo;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ShangPinTypeMapper implements RowMapper<ShangPinType>{

	@Override
	public ShangPinType mapRow(ResultSet rs, int rowNum) throws SQLException {

		ShangPinType shangpintype = new ShangPinType();
		shangpintype.setShangPinType(rs.getString("shangpintype"));
		return shangpintype;

	}
}
