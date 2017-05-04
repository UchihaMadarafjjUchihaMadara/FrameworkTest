package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.service.IndexService;

@Controller
public class IndexController {
	
	@Autowired
	private IndexService indexService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView modelAndView = new ModelAndView("index");
		
		modelAndView.addObject("user", this.indexService.getUserById(1));
		
		return modelAndView;
	}

}
