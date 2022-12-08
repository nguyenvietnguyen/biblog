package com.self.learning.biblog.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.self.learning.biblog.models.Role;
import com.self.learning.biblog.services.RoleService;

@Controller()
public class RoleController {
	@Autowired
	private RoleService roleService;

	@GetMapping("admin/role/list")
	public String roleList(Model model) {
		List<Role> roleList = roleService.findAll();
		model.addAttribute("roles", roleList);
		return "admin/role-list";
	}

	@GetMapping("admin/role/create")
	public String showCreateRolePage(Model model) {
		Role role = new Role();
		model.addAttribute("role", role);
		return "admin/create-role";
	}

	@GetMapping("admin/role/edit/{id}")
	public ModelAndView showEditRolePage(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("admin/role-detail");
		Role role = roleService.findById(id);
		mav.addObject("role", role);
		return mav;
	}
	
	@GetMapping("admin/role/delete/{id}")
	public String deleteRole(@PathVariable("id") int id) {
		Role role = roleService.findById(id);
		roleService.delete(role);
		return "redirect:/admin/role/list";
	}

	@PostMapping("admin/role/create")
	public String createRole(@ModelAttribute("role") Role role) {
		roleService.save(role);
		return "redirect:/admin/role/list";
	}
}
