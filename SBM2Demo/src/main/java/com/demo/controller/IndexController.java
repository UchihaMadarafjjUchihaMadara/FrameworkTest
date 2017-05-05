package com.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.demo.data.ResultData;
import com.demo.model.User;
import com.demo.service.UserLoginService;
import com.demo.tools.Tools;
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
	public String index(Model model, HttpSession httpSession){
		
		if (!Tools.objectIsNullOrNot(httpSession.getAttribute("user"))) {
			model.addAttribute("user", (User) httpSession.getAttribute("user"));
		}
		
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	@ResponseBody
	public String loginDo(@ModelAttribute("userLoginVo")UserLoginVo userLoginVo, HttpSession httpSession){
		ResultData data = this.userLoginService.loginIsSuccess(userLoginVo);
		
		if (data.getCode() == 10000) {
			httpSession.setAttribute("user", (User) data.getData());
		}
		
		return JSON.toJSONString(data);
	}

}
