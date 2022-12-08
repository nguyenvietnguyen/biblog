package com.self.learning.biblog.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.self.learning.biblog.models.Role;
import com.self.learning.biblog.models.User;
import com.self.learning.biblog.services.RoleService;
import com.self.learning.biblog.services.UserService;

@Controller()
public class ClientController {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	RoleService roleService;
	

	@Autowired
	UserService userService;

	@GetMapping(value = { "/", "home" })
	public String homePage() {
		return "client/index";
	}

	@GetMapping(value = { "/contact" })
	public String showContactPage() {
		return "client/contact";
	}

	@GetMapping(value = { "/post-detail/{id}" })
	public String showDetailPage() {
		return "client/show-detail";
	}

	@GetMapping(value = { "/category/{id}" })
	public String showListByCategoryPage() {
		return "client/list-post-by-category";
	}

	@GetMapping(value = { "/register" })
	public String showRegisterPage(Model model) {
		User user = new User();
		model.addAttribute("account", user);
		return "client/register";
	}

	@PostMapping(value = { "/client_register" })
	public String register(@ModelAttribute("account") User user) throws Exception {
		Role r = roleService.findByName("customer");
		List<Role> listRoles = new ArrayList<Role>();
		listRoles.add(r);
		user.setRoles(listRoles);
		userService.register(user);
		return "redirect:/";
	}
}
