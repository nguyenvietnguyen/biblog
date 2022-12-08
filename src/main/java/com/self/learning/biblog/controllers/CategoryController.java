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

import com.self.learning.biblog.models.Category;
import com.self.learning.biblog.services.CategoryService;

@Controller()
public class CategoryController {
	@Autowired
	private CategoryService cateService;

	@GetMapping("admin/category-management/list")
	public String categoryList(Model model) {
		List<Category> cateList = cateService.findAll();
		model.addAttribute("categories", cateList);
		return "admin/category-list";
	}

	@GetMapping("admin/category-management/create")
	public String showCreateCategoryPage(Model model) {
		Category category = new Category();
		model.addAttribute("category", category);
		return "admin/create-category";
	}

	@GetMapping("admin/category-management/edit/{id}")
	public ModelAndView showEditCategoryPage(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("admin/category-detail");
		Category category = cateService.findById(id);
		mav.addObject("category", category);
		return mav;
	}
	
	@GetMapping("admin/category-management/delete/{id}")
	public String deleteCategory(@PathVariable("id") int id) {
		Category category = cateService.findById(id);
		cateService.delete(category);
		return "redirect:/admin/category-management/list";
	}

	@PostMapping("admin/category-management/create")
	public String createCategory(@ModelAttribute("category") Category cate) {
		cateService.save(cate);
		return "redirect:/admin/category-management/list";
	}
}
