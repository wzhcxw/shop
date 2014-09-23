package com.gaogao.bussiness.user.bo;

/**
 * 用户类
 * @author gaohaiming 2014-8-20
 *
 */
public class User {
	

	String username;
	String pwd;
	String phonenumber;
	String uuid;
	
	/**
	 * @return the username
	 */
	public synchronized String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public synchronized void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the pwd
	 */
	public synchronized String getPwd() {
		return pwd;
	}
	/**
	 * @param pwd the pwd to set
	 */
	public synchronized void setPwd(String pwd) {
		this.pwd = pwd;
	}
	/**
	 * @return the phonenumber
	 */
	public synchronized String getPhonenumber() {
		return phonenumber;
	}
	/**
	 * @param phonenumber the phonenumber to set
	 */
	public synchronized void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	/**
	 * @return the uuid
	 */
	public synchronized String getUuid() {
		return uuid;
	}
	/**
	 * @param uuid the uuid to set
	 */
	public synchronized void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
}
