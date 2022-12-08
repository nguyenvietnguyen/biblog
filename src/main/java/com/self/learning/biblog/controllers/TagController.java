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

import com.self.learning.biblog.models.Tag;
import com.self.learning.biblog.services.TagService;

@Controller()
public class TagController {
	@Autowired
	private TagService tagService;

	@GetMapping("admin/tag/list")
	public String tagList(Model model) {
		List<Tag> tagList = tagService.findAll();
		model.addAttribute("tags", tagList);
		return "admin/tag-list";
	}

	@GetMapping("admin/tag/create")
	public String showCreateTagPage(Model model) {
		Tag tag = new Tag();
		model.addAttribute("tag", tag);
		return "admin/create-tag";
	}

	@GetMapping("admin/tag/edit/{id}")
	public ModelAndView showEditTagPage(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("admin/edit-tag");
		Tag tag = tagService.findById(id);
		mav.addObject("tag", tag);
		return mav;
	}

	@GetMapping("admin/tag/delete/{id}")
	public String deleteTag(@PathVariable("id") int id) {
		Tag tag = tagService.findById(id);
		tagService.delete(tag);
		return "redirect:/admin/tag/list";
	}

	@PostMapping("admin/tag/create")
	public String createTag(@ModelAttribute("tag") Tag tag) {
		tagService.save(tag);
		return "redirect:/admin/tag/list";
	}
}
