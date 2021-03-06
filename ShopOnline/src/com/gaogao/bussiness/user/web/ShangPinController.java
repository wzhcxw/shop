package com.gaogao.bussiness.user.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.gaogao.common.base.BaseController;
import com.gaogao.common.base.ResultMessage;
import com.gaogao.bussiness.user.bo.News;
import com.gaogao.bussiness.user.bo.ShangPin;
import com.gaogao.bussiness.user.service.ShangPinService;;




@RequestMapping("/admin/shangpin/")
@Controller
public class ShangPinController extends BaseController{
	
	private ShangPinService shangPinService;
	
	@RequestMapping("/addshangpin")
	@ResponseBody
	public Object addshangping(HttpServletRequest request) {
		ResultMessage result = null;
		//获取post 数据（json体）
		ShangPin shangpin = this.getPostDataToObject(request, ShangPin.class);
		
		if(this.shangPinService.addShangPin(shangpin))
		{
			result = ResultMessage.getSuccessResult("0" , "提交成功");
		}
		else
		{
			result = ResultMessage.getErrorResult("提交失败,请稍等再试");
		}
		
		return result;
	}
	
	@RequestMapping("/updatashangpin")
	@ResponseBody
	public Object updatashangpin(HttpServletRequest request) {
		ResultMessage result = null;
		//获取post 数据（json体）
		ShangPin shangpin = this.getPostDataToObject(request, ShangPin.class);
		
		if(this.shangPinService.updateShangPin(shangpin))
		{
			result = ResultMessage.getSuccessResult("0" , "更新成功");
		}
		else
		{
			result = ResultMessage.getErrorResult("更新失败,请稍等再试");
		}
		
		return result;
	}
	
	
	@RequestMapping("/getallshangpin")
	@ResponseBody
	public Object getallshangpin(HttpServletRequest request) {
		ResultMessage result = null;
		//获取post 数据（json体）
		
	    List<ShangPin> shangpinArray =	shangPinService.getallShangPin();
		String arr = JSON.toJSONString(shangpinArray);
		result = ResultMessage.getSuccessResult("0", "成功");
		result.setDatas(arr);
		return result;
	}
	
	@RequestMapping("/getshangpin")
	@ResponseBody
	public Object getshangpin(HttpServletRequest request) {
		ResultMessage result = null;
		//获取post 数据（json体）
		String id = request.getParameter("shangpinid");
	    ShangPin shangpinArray = shangPinService.getShangPin(id);
		String arr = JSON.toJSONString(shangpinArray);
		result = ResultMessage.getSuccessResult("0", "成功");
		result.setDatas(arr);
		return result;
	}
	
	@RequestMapping("/gettopshangpin")
	@ResponseBody
	public Object gettopshangpin(HttpServletRequest request) {
		ResultMessage result = null;
		String size = request.getParameter("size");
	    List<ShangPin> shangpinArray =	shangPinService.getTopShangPin(size);
		String arr = JSON.toJSONString(shangpinArray);
		result = ResultMessage.getSuccessResult("0", "成功");
		result.setDatas(arr);
		return result;
	}
	
	@RequestMapping("/deleteshangpin")
	@ResponseBody
	public Object deletenews(HttpServletRequest request){
		ResultMessage result = null;
		ShangPin shangpin = this.getPostDataToObject(request, ShangPin.class);

		if (!this.shangPinService.deleteShangPin(shangpin)) {
			result = ResultMessage.getSuccessResult("1", "删除失败，稍等一会再提交删除");
		} else {
			result = ResultMessage.getSuccessResult("0", "删除成功");
		}
		
		return result;
		
	}
	
	
	
	public ShangPinService getShangPinService()
	{
		
		return this.shangPinService;
	}
	
	public void setShangPinService(ShangPinService ser)
	{
		this.shangPinService = ser;
	}
	
	
	
	
	
	

}
