package com.jt.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysConfig;
import com.jt.sys.service.SysConfigService;

@Controller
@RequestMapping(produces="text/html;charset=utf-8")
public class SysConfigController {

	@Autowired
	private SysConfigService sysConfigService;
	
	@RequestMapping("/doFindPageObjects.do")
	public ModelAndView doFindPageObjects(String name, Integer pageCurrent) {
		PageObject<SysConfig> pageObject = sysConfigService.findPageObjects(name, pageCurrent);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hello");	//设置jsp页面名字
		mv.addObject("msg", pageObject);
		return mv;
	}
	
	
	
//	public void doFindPageObjects(String name, Integer pageCurrent) {
//		PageObject<SysConfig> pageObject = sysConfigService.findPageObjects(name, pageCurrent);
//		System.out.println(pageObject.getRecords());
//	}
}
