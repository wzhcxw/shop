package com.gaogao.common.base;

import java.io.UnsupportedEncodingException;
import java.io.*;
import javax.servlet.*;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.gaogao.common.util.Base64Util;
import com.gaogao.common.util.DesUtil;

public class BaseController {

	private String charset = "UTF-8";
	private String secretKey = "12345678";

	
	
	public <T> T getPostDataToObject(HttpServletRequest request, Class<T> clazz) {
		
		StringBuffer sb = new StringBuffer() ; 
		T object = null;
		try{
			ServletInputStream is = request.getInputStream(); 
			InputStreamReader isr = new InputStreamReader(is,"UTF-8");   
			BufferedReader br = new BufferedReader(isr); 
			String s = "" ; 
			while((s=br.readLine())!=null){ 
			sb.append(s) ; 
			} 
			String str =sb.toString(); 
			
			object = JSON.parseObject(str, clazz);
			
		}
		catch(Exception e){
			
		}
		
		return object;
	}
	/**
	 * 解密Url查询查询参数并转为对象
	 * 
	 * @param request
	 * @return
	 */
	public <T> T getParametersObject(HttpServletRequest request, Class<T> clazz) {
		String queryStr = request.getQueryString();
		if (null != queryStr && !"".equals(queryStr)) {
			String ParametersJstr = this.decryptBase64(queryStr);
			if (ParametersJstr.contains("body={")) {
				T object;
				try {
					object = JSON.parseObject(
							ParametersJstr.replace("body={", "{"), clazz);
				} catch (Exception e) {
					throw new RuntimeException("参数对象错误");
				}
				return object;

			} else {
				throw new RuntimeException("参数不合法");
			}

		} else {
			throw new RuntimeException("参数为空");
		}
	}

	/**
	 * 对象转为JSON字符串并加密
	 * 
	 * @param source
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String getJsonAndEncrypt(Object object) {

		String resultJstr = JSON.toJSONString(object);
		String resultStr = this.encryptBase64(resultJstr);

		return resultStr;
	}

	/**
	 * 加密成字符串
	 * 
	 * @param source
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String encryptBase64(String source) {

		String resultStr = null;
		try {
			byte[] result = DesUtil.encryptByDes(source.getBytes(this.charset),
					secretKey);
			if (null != source) {
				resultStr = new String(Base64Util.encode(result));
				resultStr = resultStr.replace("+", "_").replace("/", "-");
			}

		} catch (Exception e) {
			throw new RuntimeException("编码失败");
		}
		return resultStr;
	}

	/**
	 * 解密成字符串
	 * 
	 * @param source
	 * @return
	 * @throws Exception
	 */
	public String decryptBase64(String source) {
		String resultStr = null;
		try {
			if (null != source) {
				source = source.replace("_", "+").replace("-", "/");
				byte[] result = DesUtil.decryptByDes(
						Base64Util.decode(source.getBytes()), secretKey);
				resultStr = new String(result, this.charset);
			}
		} catch (Exception e) {
			throw new RuntimeException("解码失败");
		}
		return resultStr;
	}

	/** 基于@ExceptionHandler异常处理 */
	@ExceptionHandler
	@ResponseBody
	public Object exp(HttpServletRequest request, Exception ex) {
		ex.printStackTrace();
		return ResultMessage.getErrorResult(ex.getMessage());
	}

	/**
	 * @return the charset
	 */
	public synchronized String getCharset() {
		return charset;
	}

	/**
	 * @param charset
	 *            the charset to set
	 */
	public synchronized void setCharset(String charset) {
		this.charset = charset;
	}

	/**
	 * @return the secretKey
	 */
	public synchronized String getSecretKey() {
		return secretKey;
	}

	/**
	 * @param secretKey
	 *            the secretKey to set
	 */
	public synchronized void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
}
