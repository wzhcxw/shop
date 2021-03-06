package com.gaogao.bussiness.user.service;

import java.util.List;

import com.gaogao.bussiness.user.bo.News;

public interface NewsService {

	public boolean addNews(News news);
	public boolean updateNews(News news);
	public List<News> getNews(String uiid , String seconduiid,String pagesize);
	
	public boolean deleteNews(News title);
	public List<News> getallNews();
	public List<News> getNewsByTitle(String title);
	public List<News> getTopNews(String size,String seconduiid,String uiid);
	
}
