package com.gaogao.common.base;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 登录重定向拦截器
 * @author gaohaiming 2014-8-20
 *
 */
public class BaseInterceptor extends HandlerInterceptorAdapter {
	
	List<String> excludeControllers;
	/**
	 * Controller之前执行
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		String url = request.getRequestURI();
		System.out.println("请求地址" + url);
		for (String controller : excludeControllers) {
			if(url.contains(controller)) {
				return super.preHandle(request, response, handler);
			}
		}
		String uerName = (String) request.getSession().getAttribute("uerName");
		if (null == uerName || "".equals(uerName)) {
			//response.sendRedirect("notlogin.do");  
		}

		return super.preHandle(request, response, handler);
	}

	/**
	 * 显示视图前执行
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

	/**
	 * 最后执行，可用于释放资源
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

	/**
	 * @return the excludeControllers
	 */
	public synchronized List<String> getExcludeControllers() {
		return excludeControllers;
	}

	/**
	 * @param excludeControllers the excludeControllers to set
	 */
	public synchronized void setExcludeControllers(List<String> excludeControllers) {
		this.excludeControllers = excludeControllers;
	}


}
