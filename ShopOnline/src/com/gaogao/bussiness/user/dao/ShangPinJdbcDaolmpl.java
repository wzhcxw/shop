package com.gaogao.bussiness.user.dao;

import java.util.List;

import com.gaogao.bussiness.user.bo.News;
import com.gaogao.bussiness.user.bo.NewsMapper;
import com.gaogao.bussiness.user.bo.ShangPin;
import com.gaogao.bussiness.user.bo.ShangPinMapper;
import com.gaogao.common.base.JdbcDao;

public class ShangPinJdbcDaolmpl extends  JdbcDao implements ShangPinDao{
	
	@Override
	public boolean addShangPin(ShangPin shangping)
	{

		 String sql = "insert into sku (name,shangpinid,price,dscr,guige,type,zhongliang,chandi,iamgeurl1,iamgeurl2,iamgeurl3) values('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s');";
		 sql = String.format(sql, shangping.getName(),shangping.getShangPinid(),shangping.getPrice(),shangping.getDscr(),shangping.getGuige(),shangping.getType(),shangping.getZhongLiang(),shangping.getChandi(),shangping.getIamgeUrl1(),shangping.getIamgeUrl2(),shangping.getIamgeUrl3());
		 return this.update(sql.toString());
		
	}
	@Override
	public boolean updateShangPin(ShangPin shangping)
	{

		String sqlll = "UPDATE sku SET  name = '%s',price = '%s' , dscr = '%s' , guige = '%s' , type = '%s' , zhongliang = '%s' , chandi = '%s' , iamgeurl1 = '%s' , iamgeurl2 = '%s' , iamgeurl3 = '%s'  where shangpinid = '%s' ;";
		sqlll = String.format(sqlll, shangping.getName(),shangping.getPrice(),shangping.getDscr(),shangping.getGuige(),shangping.getType(),shangping.getZhongLiang(),shangping.getChandi(),shangping.getIamgeUrl1(),shangping.getIamgeUrl2(),shangping.getIamgeUrl3(),shangping.getShangPinid());
		return this.update(sqlll.toString());
	}
	@Override
	public List<ShangPin> getShangPin(ShangPin shangpin)
	{
		String sqll = "select * from sku where shangpinid = %s ;";
		sqll = String.format(sqll, shangpin.getShangPinid());
		ShangPinMapper newsmaper = new ShangPinMapper();
		List<ShangPin> newslist = this.query( sqll, newsmaper ) ;
	    return newslist;
	}
	@Override
	public List<ShangPin> getallShangPin()
	{
		String sqll = "select *  from sku;";
		ShangPinMapper shangpinmaper = new ShangPinMapper();
		List<ShangPin> shangpinlist = this.query( sqll, shangpinmaper ) ;
	    return shangpinlist;
		
	}
	@Override
	public boolean deleteShangPin(ShangPin shangpin)
	{
		String sqll = "DELETE FROM sku WHERE shangpinid='%s';";
		String str = shangpin.getShangPinid();
		
		sqll = String.format(sqll, str);
		this.getJdbcTemplate().execute(sqll);
	    return true;
		
	}
	@Override
	public List<ShangPin> getTopShangPin(String size)
	{
		String sqll = "select  * from sku  limit %s;" ;
		sqll = String.format(sqll, size);
		ShangPinMapper shangpinmaper = new ShangPinMapper();
		List<ShangPin> shangpinlist = this.query( sqll, shangpinmaper ) ;
	    return shangpinlist;
	}
}
