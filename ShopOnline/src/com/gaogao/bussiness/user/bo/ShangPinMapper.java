package com.gaogao.bussiness.user.bo;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ShangPinMapper implements RowMapper<ShangPin> {

	String name;//名称
	String shangpinid;//商品id
	String price;
	
	String dscr;// 商品介绍

	String guige;	//型号
	String type;//类型
	String zhongliang;
	String chandi;
	
	String iamgeurl1;
	String iamgeurl2;
	String iamgeurl3;
	
	@Override
	public ShangPin mapRow(ResultSet rs, int rowNum) throws SQLException {

		ShangPin sp = new ShangPin();
		sp.setName(rs.getString("name"));
		sp.setChandi(rs.getString("chandi"));
		sp.setDscr(rs.getString("dscr"));
		sp.setGuige(rs.getString("guige"));
		sp.setIamgeUrl1(rs.getString("imageurl1"));
		sp.setIamgeUrl2(rs.getString("imageurl2"));
		sp.setIamgeUrl3(rs.getString("imageurl3"));
		sp.setPrice(rs.getString("price"));
		sp.setShangPinid(rs.getString("shangpinid"));
		sp.setType(rs.getString("type"));
		sp.setZhongLiang(rs.getString("zhongliang"));
		
		return sp;

	}

}