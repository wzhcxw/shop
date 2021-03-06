package com.gaogao.bussiness.user.dao;

import java.util.List;

import com.gaogao.bussiness.user.bo.News;


public interface NewsDao {
	
	//添加文章到数据库
	public boolean addNews(News news);
	public boolean updateNews(News user);
	public List<News> getNews(String uiid , String seconduiid,String pagesize);
	public List<News> getallNews();
	public boolean deleteNews(News title);
	public List<News> getNewsByTitle(String title);
	public List<News> getTopNews(String size,String seconduiid,String uiid);

}
