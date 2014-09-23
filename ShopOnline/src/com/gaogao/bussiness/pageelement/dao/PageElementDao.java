package com.gaogao.bussiness.pageelement.dao;

import java.util.List;

import com.gaogao.bussiness.pageelement.bo.PageElement;

/**
 * 页面元素DAO层接口
 * 
 * @author gaohaiming 2014-8-29
 * 
 */
public interface PageElementDao {
	/**
	 * 添加页面元素
	 * 
	 * @param user
	 * @return
	 */
	public boolean addPageElement(PageElement pageElement);

	/**
	 * 查询页面元素内容
	 * 
	 * @param userName
	 * @return
	 */
	public List<PageElement> queryPageElementByUiid(String uiid);

	
	/**
	 * 修改页面元素内容
	 * 
	 * @param user
	 * @return
	 */
	public boolean updatePageElement(PageElement pageElement);
}
