package com.gaogao.bussiness.pageelement.dao;

import java.util.ArrayList;
import java.util.List;

import com.gaogao.bussiness.pageelement.bo.PageElement;
import com.gaogao.bussiness.pageelement.bo.PageElementMapper;
import com.gaogao.common.base.JdbcDao;

/**
 * 页面元素DAO层Jdbc方式实现
 * 
 * @author gaohaiming 2014-8-20
 * 
 */
public class PageElementJdbcDaoImpl extends JdbcDao implements PageElementDao {

	@Override
	public boolean addPageElement(PageElement pageElement) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PageElement> queryPageElementByUiid(String uiid) {
		List<PageElement> pageElements = new ArrayList<PageElement>();
		String sql = "select * from pageelement where uiid='" + uiid + "' order by sort";
		pageElements = this.query(sql, new PageElementMapper());
		return pageElements;
	}

	@Override
	public boolean updatePageElement(PageElement pageElement) {
		// TODO Auto-generated method stub
		return false;
	}

}
