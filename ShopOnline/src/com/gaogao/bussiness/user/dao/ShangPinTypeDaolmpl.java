package com.gaogao.bussiness.user.dao;

import java.util.List;

import com.gaogao.bussiness.user.bo.ShangPinTypeMapper;
import com.gaogao.bussiness.user.bo.ShangPinType;
import com.gaogao.common.base.JdbcDao;

public class ShangPinTypeDaolmpl extends  JdbcDao implements ShangPinTypeDao{

	public boolean addShangPinType(ShangPinType shangpingtype)
	{
		 String sql = "insert into skutype (shangpintype) values('%s');";
		 sql = String.format(sql, shangpingtype.getShangPinType());
		 return this.update(sql.toString());

	}
	
	public List<ShangPinType> getallShangPinType()
	{
		String sqll = "select *  from skutype;";
		ShangPinTypeMapper shangpinmaper = new ShangPinTypeMapper();
		List<ShangPinType> shangpinlist = this.query( sqll, shangpinmaper ) ;
	    return shangpinlist;
		
		
	}
}
