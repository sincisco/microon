package com.zijin.microon.ueditor.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zijin.microon.model.User;
import com.zijin.microon.service.UserService;
import com.zijin.microon.ueditor.ActionEnter;
import com.zijin.microon.ueditor.ConfigManager;

@Controller
@RequestMapping("/ueditor")
public class UeditorController {

	private Log log=LogFactory.getLog(UeditorController.class);
	
	@Autowired
	private ConfigManager configManager=null;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/showInfo/{userId}")
	public String showUserInfo(ModelMap modelMap, @PathVariable int userId){
		User user = userService.getUserById(userId);
		modelMap.addAttribute("user", user);
		return "/user/showInfo";
	}
	
	@RequestMapping(value="/controller",params="action", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView doAction(HttpServletRequest request){
		log.info("进入方法");
		log.info(this.configManager.toString());
		String rootPath=request.getRealPath("/");
		String jsonStr= new ActionEnter( request, rootPath ).exec();
		return new ModelAndView("json").addObject("json", jsonStr);
	}
	
}
