package com.gaogao.bussiness.user.bo;


public class ShangPin {

	String name;//名称
	String shangpinid;//商品id
	String price;
	
	String dscr;// 商品介绍
	String detaildes;// 商品详情

	String guige;	//型号
	String type;//类型
	String zhongliang;
	String chandi;
	
	String iamgeurl1;
	String iamgeurl2;
	String iamgeurl3;
	
	public synchronized String getDetailDes() {
		return detaildes;
	}
	
	public synchronized String getName() {
		return name;
	}
	
	public synchronized String getShangPinid() {
		return shangpinid;
	}
	public synchronized String getPrice() {
		return price;
	}
	public synchronized String getGuige() {
		return guige;
	}
	public synchronized String getDscr() {
		return dscr;
	}
	public synchronized String getType() {
		return type;
	}
	public synchronized String getZhongLiang() {
		return zhongliang;
	}
	public synchronized String getChandi() {
		return chandi;
	}
	public synchronized String getIamgeUrl1() {
		return iamgeurl1;
	}
	public synchronized String getIamgeUrl2() {
		return iamgeurl2;
	}
	public synchronized String getIamgeUrl3() {
		return iamgeurl3;
	}

	
	
	public synchronized void setName(String name) {
		this.name = name;
	}
	public synchronized void setDetailDes(String detaildes) {
		this.detaildes = detaildes;
	}
	public synchronized void setShangPinid(String shangpinid) {
		this.shangpinid = shangpinid;
	}
	public synchronized void setPrice(String price) {
		this.price = price;
	}
	public synchronized void setDscr(String dscr) {
		this.dscr = dscr;
	}
	public synchronized void setGuige(String guige) {
		this.guige = guige;
	}
	public synchronized void setType(String type) {
		this.type = type;
	}
	public synchronized void setZhongLiang(String zhongliang) {
		this.zhongliang = zhongliang;
	}
	public synchronized void setChandi(String chandi) {
		this.chandi = chandi;
	}
	public synchronized void setIamgeUrl1(String iamgeurl1) {
		this.iamgeurl1 = iamgeurl1;
	}
	public synchronized void setIamgeUrl2(String iamgeurl2) {
		this.iamgeurl2 = iamgeurl2;
	}
	public synchronized void setIamgeUrl3(String iamgeurl3) {
		this.iamgeurl3 = iamgeurl3;
	}
	
	
}
