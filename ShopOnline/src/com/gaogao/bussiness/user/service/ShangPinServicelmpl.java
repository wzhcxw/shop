package com.gaogao.bussiness.user.service;

import java.util.List;

import com.gaogao.bussiness.user.bo.ShangPin;
import com.gaogao.bussiness.user.bo.ShangPinMapper;
import com.gaogao.bussiness.user.dao.ShangPinDao;

public class ShangPinServicelmpl implements ShangPinService{
	private ShangPinDao shangPinDao;
	
	public synchronized ShangPinDao getShangPinDao()
	{
		return shangPinDao;
	}
	
	public synchronized void setShangPinDao(ShangPinDao shangpingdao)
	{
		
		this.shangPinDao = shangpingdao;
	}
	
	
	public boolean addShangPin(ShangPin shangping)
	{
		
		
		return shangPinDao.addShangPin(shangping);
		
	}
	
	public boolean updateShangPin(ShangPin shangpin)
	{
		return this.shangPinDao.updateShangPin(shangpin);
	}
	
	public List<ShangPin> getShangPin(ShangPin shangpin)
	{
		return this.shangPinDao.getShangPin(shangpin);
	}
	
	public List<ShangPin> getallShangPin()
	{
		return this.shangPinDao.getallShangPin();
		
	}
	
	public boolean deleteShangPin(ShangPin shangpin)
	{
		return this.shangPinDao.deleteShangPin(shangpin);
		
	}
	


}
