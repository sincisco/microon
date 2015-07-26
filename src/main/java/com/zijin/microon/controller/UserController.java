package com.zijin.microon.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zijin.microon.model.User;
import com.zijin.microon.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private static Log log=LogFactory.getLog(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/showInfo/{userId}")
	public String showUserInfo(ModelMap modelMap, @PathVariable int userId){
		User user = userService.getUserById(userId);
		modelMap.addAttribute("user", user);
		return "/user/showInfo";
	}
	
	@RequestMapping("/showInfos")
	public @ResponseBody Object showUserInfos(){
		List<User> userInfos = userService.getUsers();
		return userInfos;
	}
}
