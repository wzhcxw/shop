package com.gaogao.bussiness.user.dao;

import com.gaogao.bussiness.user.bo.ShangPin;
import com.gaogao.common.base.JdbcDao;

public class ShangPinJdbcDaolmpl extends  JdbcDao implements ShangPinDao{
	
	
	public boolean addShangPin(ShangPin shangping)
	{

		 String sql = "insert into sku (name,shangpinid,price,dscr,guige,type,zhongliang,chandi,imageurl1,imageurl2,imageurl3) values('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s');";
		 sql = String.format(sql, shangping.getName(),shangping.getShangPinid(),shangping.getPrice(),shangping.getDscr(),shangping.getGuige(),shangping.getType(),shangping.getZhongLiang(),shangping.getChandi(),shangping.getIamgeUrl1(),shangping.getIamgeUrl2(),shangping.getIamgeUrl3());
		 return this.update(sql.toString());
		
	}
}
