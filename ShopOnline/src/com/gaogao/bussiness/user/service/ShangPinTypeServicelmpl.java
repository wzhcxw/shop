package com.gaogao.bussiness.user.service;

import java.util.List;

import com.gaogao.bussiness.user.bo.ShangPinType;
import com.gaogao.bussiness.user.dao.ShangPinTypeDao;

public class ShangPinTypeServicelmpl implements ShangPinTypeService{

	private ShangPinTypeDao shangPinTypeDao;
	
	public synchronized ShangPinTypeDao getShangPinTypeDao() {
		
		return shangPinTypeDao;
	}
	public synchronized void setShangPinTypeDao(ShangPinTypeDao typedao) {
		
		this.shangPinTypeDao = typedao;
	}
	
	public boolean addShangPinType(ShangPinType type)
	{
		return shangPinTypeDao.addShangPinType(type);
		
	}
	public List<ShangPinType> getallShangPinType()
	{
		return shangPinTypeDao.getallShangPinType();
	}
}
