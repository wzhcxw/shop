package com.gaogao.bussiness.user.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gaogao.bussiness.user.bo.News;
import com.gaogao.bussiness.user.bo.User;
import com.gaogao.bussiness.user.service.NewsServicelmpl;
import com.gaogao.bussiness.user.service.NewsService;
import com.gaogao.bussiness.user.service.UserService;
import com.gaogao.common.base.BaseController;
import com.gaogao.common.base.ResultMessage;
import com.gaogao.common.util.Md5Util;
import com.alibaba.fastjson.*;
import java.util.*;


@RequestMapping("/admin/news/")
@Controller
public class NewsController extends BaseController{
	
	
	private NewsService newsService;
	
	//添加文章接口
	@RequestMapping("/addnews")
	@ResponseBody
	public Object addnews(HttpServletRequest request) {
		ResultMessage result = null;
		//获取post 数据（json体）
		News news = this.getPostDataToObject(request, News.class);
		
		if(this.newsService.addNews(news))
		{
			result = ResultMessage.getSuccessResult("0" , "提交成功");
		}
		else
		{
			result = ResultMessage.getErrorResult("提交失败,请稍等再试");
		}
		
		return result;
	}
	
	
	@RequestMapping("/updatanews")
	@ResponseBody
	public Object updatanews(HttpServletRequest request){
		ResultMessage result = null;
		News news = this.getParametersObject(request, News.class);

		if (this.newsService.updateNews(news)) {
			result = ResultMessage.getSuccessResult("1", "更新失败，稍等一会再提交");
		} else {
			result = ResultMessage.getSuccessResult("0", "提交成功");
		}
		
		return result;
		
	}
	
	@RequestMapping("/deletenews")
	@ResponseBody
	public Object deletenews(HttpServletRequest request){
		ResultMessage result = null;
		News news = this.getParametersObject(request, News.class);

		if (this.newsService.deleteNews(news.getUiid(), news.getSeconduiid())) {
			result = ResultMessage.getSuccessResult("1", "删除失败，稍等一会再提交删除");
		} else {
			result = ResultMessage.getSuccessResult("0", "删除成功");
		}
		
		return result;
		
	}
	
	@RequestMapping("/getnews")
	@ResponseBody
	public Object getNews(HttpServletRequest request){
		ResultMessage result = null;
		News news = this.getParametersObject(request, News.class);
		
	    List<News> newsArray =	newsService.getNews(news.getUiid(), news.getSeconduiid(), 20);
		String arr = JSON.toJSONString(newsArray);
		result = ResultMessage.getSuccessResult("0", "成功");
		result.setDatas(arr);
		return result;
		
	}
	
	
	public NewsService getNewsService() {
		return newsService;
	}


	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}
}