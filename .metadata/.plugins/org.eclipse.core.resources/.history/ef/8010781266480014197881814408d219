package com.gaogao.bussiness.user.service;

import com.gaogao.bussiness.user.bo.ShangPin;
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
	


}
