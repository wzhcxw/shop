package com.gaogao.bussiness.user.bo;

public class ShangPinType {
	
	String shangpintype;
	
	
	public synchronized String getShangPinType() {
		return shangpintype;
	}
	
	public synchronized void setShangPinType(String shangpintype) {
		this.shangpintype = shangpintype;
	}
}
