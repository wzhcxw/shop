package com.gaogao.bussiness.user.service;

import java.util.List;

import com.gaogao.bussiness.user.bo.News;
import com.gaogao.bussiness.user.dao.NewsDao;

public class NewsServicelmpl implements NewsService{

	
	private NewsDao newsDao;

	/**
	 * @return the userDao
	 */
	public synchronized NewsDao getNewsDao() {
		return newsDao;
	}

	/**
	 * @param userDao
	 *            the userDao to set
	 */
	public synchronized void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}
	@Override
	public boolean addNews(News news)
	{
		newsDao.addNews(news);
		
		return true;
	}
	
	@Override
	public boolean updateNews(News news)
	{
		return newsDao.updateNews(news);
	}
	
	@Override
	public List<News> getNews(String uiid , String seconduiid,String pagesize)
	{
		return newsDao.getNews(uiid, seconduiid, pagesize);
	}

	@Override
	public boolean deleteNews(News title)
	{
		
		return newsDao.deleteNews(title);
	}
	@Override
	public List<News> getallNews()
	{
		return newsDao.getallNews();
		
	}
	@Override
	public List<News> getNewsByTitle(String title)
	{
		return newsDao.getNewsByTitle(title);
		
	}
	
	@Override //获取前 size条数据
	public List<News> getTopNews(String size,String seconduiid,String uiid)
	{
		return newsDao.getTopNews(size ,seconduiid,uiid);
	}
	

}
