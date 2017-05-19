package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.demo.data.ResultData;
import com.demo.service.UserLoginService;
import com.demo.vo.UserLoginVo;



@Controller
public class IndexController {
	
	@Autowired
	private UserLoginService userLoginService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(){
		return "login";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(){
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	@ResponseBody
	public String loginDo(@ModelAttribute("userLoginVo")UserLoginVo userLoginVo){
		ResultData data = this.userLoginService.loginIsSuccess(userLoginVo);
		
		return JSON.toJSONString(data);
	}

}
