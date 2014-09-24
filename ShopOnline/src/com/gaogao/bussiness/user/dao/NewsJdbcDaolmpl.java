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
		 String sql = "insert into newslisttable (content,seconduiid,sort,title,uiid) values('%s','%s','%s','%s','%s');";
		 sql = String.format(sql, news.getContent(),news.getSeconduiid(),news.getSort(),news.getTitle(),news.getUiid());
		return this.update(sql.toString());
		
	}
	
	//更新文章
	@Override
	public boolean updateNews(News news){
		String sqlll = "update newslisttable set 'content' = '%s' , 'sort' = '%s' , 'title' = '%s' where 'uiid' = '%s' and seconduiid = '%s' ;";
		sqlll = String.format(sqlll, news.getContent(),news.getSort(),news.getTitle(),news.getUiid(), news.getSeconduiid());
		return this.update(sqlll.toString());
	}
	
	@Override //获取文章数据，参数：uiid，seconduiid， 条数
	public List<News> getNews(String uiid , String seconduiid ,int pagesize)
	{
		String sqll = "select title , content from newslisttable where 'uiid' = %s and 'seconduiid' = '%s';";
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
	
	
	
	@Override //删除文章
	public boolean deleteNews(News news)
	{
		               
		String sqll = "DELETE FROM newslisttable WHERE title='%s';";
		String str = news.getTitle();
		
		sqll = String.format(sqll, str);
		this.getJdbcTemplate().execute(sqll);
	    return true;
	}
	
	
	
}
