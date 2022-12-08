package com.self.learning.biblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.self.learning.biblog.services.UserService;

@Controller()
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("admin/user-management/list")
	public String userList() {
		
		return "admin/user-list";
	}
}
