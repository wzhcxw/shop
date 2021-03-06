package com.gaogao.bussiness.user.dao;
import java.sql.PreparedStatement;

import org.springframework.jdbc.core.RowMapper;

import com.gaogao.bussiness.user.bo.*;
import com.gaogao.common.base.JdbcDao;

import java.util.*;


public class NewsJdbcDaolmpl extends  JdbcDao implements NewsDao
{
	
	//添加文章
	public boolean addNews(News news)
	{
		 String sql = "insert into newslisttable (content,seconduiid,sort,title,uiid,date,titleimage) values('%s','%s','%s','%s','%s','%s','%s');";
		 sql = String.format(sql, news.getContent(),news.getSeconduiid(),news.getSort(),news.getTitle(),news.getUiid(),news.getDate(),news.getTitleImage());
		return this.update(sql.toString());
		
	}
	
	//更新文章
	@Override
	public boolean updateNews(News news){
		String sqlll = "UPDATE newslisttable SET titleimage = '%s', content = '%s',sort = '%s' , uiid = '%s' , seconduiid = '%s'  where title = '%s' ;";
		sqlll = String.format(sqlll, news.getTitleImage(),news.getContent(),news.getSort(),news.getUiid(), news.getSeconduiid(),news.getTitle());
		return this.update(sqlll.toString());
	}
	
	@Override //获取文章数据，参数：uiid，seconduiid， 条数
	public List<News> getNews(String uiid , String seconduiid ,String pagesize)
	{
		String sqll = "select * from newslisttable where uiid = '%s' and seconduiid = '%s';";
		sqll = String.format(sqll, uiid , seconduiid);
		NewsMapper newsmaper = new NewsMapper();
		List<News> newslist = this.query( sqll, newsmaper ) ;
	    return newslist;
		
	}
	
	
	@Override //获取所有文章
	public List<News> getallNews()
	{
		String sqll = "select *  from newslisttable;";

		NewsMapper newsmaper = new NewsMapper();
		List<News> newslist = this.query( sqll, newsmaper ) ;
	    return newslist;
		
	}
	@Override //获取获取文章
	public List<News> getNewsByTitle(String title )
	{
		String sqll = "select *  from newslisttable WHERE title='%s';";
		
		sqll = String.format(sqll, title);
		
		NewsMapper newsmaper = new NewsMapper();
		
		List<News> newslist = this.query( sqll, newsmaper ) ;
	    return newslist;
		
	}
	
	
	@Override //删除文章
	public boolean deleteNews(News news)
	{
		               
		String sqll = "DELETE FROM newslisttable WHERE title='%s';";
		String str = news.getTitle();
		
		sqll = String.format(sqll, str);
		this.getJdbcTemplate().execute(sqll);
	    return true;
	}
	
	@Override //获取前 size条数据
	public List<News> getTopNews(String size ,String seconduiid,String uiid)
	{
		String sqll = "select  * from newslisttable where seconduiid = '%s' and uiid ='%s' limit %s;" ;
		sqll = String.format(sqll,seconduiid, uiid ,size);
		NewsMapper newsmaper = new NewsMapper();
		List<News> newslist = this.query( sqll, newsmaper ) ;
	    return newslist;
	}
	
	
	
}
