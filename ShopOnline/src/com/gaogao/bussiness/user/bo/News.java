package com.gaogao.bussiness.user.bo;

public class News {

	String title;
	String seconduiid;
	String uiid;
	
	String content;
	String sort;
	
	/**
	 * {"seconduiid":"newss","uiid":"home","title":"123","data":"<p>wwwwwww</p>"}
	 * @return the title
	 */
	public synchronized String getTitle() {
		return title;
	}
	public synchronized String getSeconduiid() {
		return seconduiid;
	}
	public synchronized String getUiid() {
		return uiid;
	}
	public synchronized String getContent() {
		return content;
	}
	public synchronized String getSort() {
		return sort;
	}
	
	
	/**
	 * @param title the title to set
	 */
	public synchronized void setTitle(String title) {
		this.title = title;
	}
	public synchronized void setSort(String sort) {
		this.sort = sort;
	}
	public synchronized void setSeconduiid(String seconduiid) {
		this.seconduiid = seconduiid;
	}
	public synchronized void setUiid(String uiid) {
		this.uiid = uiid;
	}
	public synchronized void setContent(String content) {
		this.content = content;
	}
	
	
}