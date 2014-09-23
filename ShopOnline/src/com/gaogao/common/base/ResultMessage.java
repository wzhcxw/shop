package com.gaogao.common.base;

/**
 * 返回给客户端的结果类
 * 
 * @author gaohaiming 2014-8-20
 * 
 */
public class ResultMessage {

	String code;
	String flag;
	String message;
	String datas;

	public ResultMessage(String code, String flag, String message) {
		super();
		this.code = code;
		this.flag = flag;
		this.message = message;
	}

	/**
	 * 接口调用正确结果
	 * 
	 * @param message
	 * @return
	 */
	public static ResultMessage getSuccessResult(String flag, String message) {
		return new ResultMessage("0", flag, message);
	}
	/**
	 * 接口调用错误结果
	 * @param message
	 * @return
	 */
	public static ResultMessage getErrorResult(String message) {
		return new ResultMessage("1", "-1", message);
	}

	/**
	 * @return the code
	 */
	public synchronized String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public synchronized void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the flag
	 */
	public synchronized String getFlag() {
		return flag;
	}

	/**
	 * @param flag
	 *            the flag to set
	 */
	public synchronized void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * @return the message
	 */
	public synchronized String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public synchronized void setMessage(String message) {
		this.message = message;
	}
	
	public synchronized String getDatas() {
		return datas;
	}
	public synchronized void setDatas(String Datas) {
		this.datas = Datas;
	}

}
