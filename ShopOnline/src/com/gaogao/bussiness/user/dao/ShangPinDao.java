package com.gaogao.bussiness.user.dao;

import com.gaogao.bussiness.user.bo.ShangPin;

import java.util.List;

public interface ShangPinDao {
	
	public boolean addShangPin(ShangPin shangping);
	
	public boolean updateShangPin(ShangPin shangpin);
	
	public ShangPin getShangPin(String id);
	public List<ShangPin> getallShangPin();
	
	public boolean deleteShangPin(ShangPin shangpin);
	
	public List<ShangPin> getTopShangPin(String size);

}
