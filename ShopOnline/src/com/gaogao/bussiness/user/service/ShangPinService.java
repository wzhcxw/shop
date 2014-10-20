package com.gaogao.bussiness.user.service;

import java.util.List;

import com.gaogao.bussiness.user.bo.ShangPin;

public interface ShangPinService {
	
	public boolean addShangPin(ShangPin shangping);
	public boolean updateShangPin(ShangPin shangpin);
	
	public ShangPin getShangPin(String id);
	public List<ShangPin> getallShangPin();
	
	public boolean deleteShangPin(ShangPin shangpin);
	public List<ShangPin> getTopShangPin(String size);

}
