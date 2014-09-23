package com.gaogao.bussiness.user.service;

import java.util.List;

import com.gaogao.bussiness.user.bo.News;

public interface NewsService {

	public boolean addNews(News news);
	public boolean updateNews(News news);
	public List<News> getNews(String uiid , String seconduiid,int pagesize);
	
	public boolean deleteNews(String uiid , String seconduiid);
}
