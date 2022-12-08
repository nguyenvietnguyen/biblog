package com.self.learning.biblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller()
public class EmailSubscribeController {
	@GetMapping("admin/email-subscribe-management/list")
	public String emailSubscribeList() {
		return "admin/email-subscribe-list";
	}
}
