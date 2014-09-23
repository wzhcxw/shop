package com.gaogao.bussiness.pageelement.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gaogao.bussiness.pageelement.bo.PageElement;
import com.gaogao.bussiness.pageelement.dao.PageElementDao;
import com.gaogao.common.base.BaseController;
import com.gaogao.common.base.ResultMessage;

/**
 * 页面元素服务端controller
 * 
 * @author gaohaiming 2014-8-20
 * 
 */
@RequestMapping("page")
@Controller
public class PageElementController extends BaseController {

	private PageElementDao pageElementDao;

	/**
	 * 用户名是否可用
	 * 
	 * @param Port
	 */
	@RequestMapping("/getContent")
	@ResponseBody
	public Object isNameUsed(HttpServletRequest request, String uiid) {
		List<PageElement> pageElements = this.pageElementDao
				.queryPageElementByUiid(uiid);
		StringBuilder message = new StringBuilder();
		for (PageElement pageElement : pageElements) {
			String type = pageElement.getType();
			if ("title".equals(type)) {
				message.append("<h3>");
				message.append(pageElement.getContent());
				message.append("</h3>");
			} else if ("p".equals(type)) {
				message.append("<p>");
				message.append(pageElement.getContent());
				message.append("</p>");
			}
		}
		return ResultMessage.getSuccessResult("1", message.toString());
	}

	public PageElementDao getPageElementDao() {
		return pageElementDao;
	}

	public void setPageElementDao(PageElementDao pageElementDao) {
		this.pageElementDao = pageElementDao;
	}

}