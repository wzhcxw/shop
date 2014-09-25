package com.gaogao.bussiness.user.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gaogao.common.base.BaseController;
import com.gaogao.common.base.ResultMessage;
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
	
	
	public ShangPinService getShangPinService()
	{
		
		return this.shangPinService;
	}
	
	public void setShangPinService(ShangPinService ser)
	{
		this.shangPinService = ser;
	}
	
	
	
	
	
	

}
