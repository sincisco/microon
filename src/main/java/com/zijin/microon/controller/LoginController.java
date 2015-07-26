package com.zijin.microon.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zijin.microon.service.UserService;

@Controller
public class LoginController {
	
	private static Log log=LogFactory.getLog(LoginController.class);
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		return "login/login";
	}
}