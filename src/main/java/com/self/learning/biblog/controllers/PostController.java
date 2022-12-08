package com.self.learning.biblog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.self.learning.biblog.models.Category;
import com.self.learning.biblog.models.Post;
import com.self.learning.biblog.models.Tag;
import com.self.learning.biblog.models.User;
import com.self.learning.biblog.services.CategoryService;
import com.self.learning.biblog.services.PostService;
import com.self.learning.biblog.services.TagService;
import com.self.learning.biblog.services.UserService;

@Controller()
public class PostController {
	@Autowired
	CategoryService cateService;
	@Autowired
	UserService userService;
	@Autowired
	PostService postService;
	@Autowired
	TagService tagService;

	@GetMapping("admin/post-management/list")
	public String postList(Model model) {
		List<Post> posts = postService.findAll();
		model.addAttribute("posts", posts);
		return "admin/post-list";
	}

	@GetMapping("admin/post/create")
	public String showCreatePost(Model model) {
		Post post = new Post();
		model.addAttribute("post", post);
		List<Category> categorys = cateService.findAll();
		List<User> users = userService.findAll();
		List<Tag> tags = tagService.findAll();
		model.addAttribute("allCategory", categorys);
		model.addAttribute("allUser", users);
		model.addAttribute("allTag", tags);
		
		return "admin/create-post";
	}
	
	@GetMapping("admin/post/edit/{id}")
	public String showEditPostPage(@PathVariable("id") int id, Model model) {
		Post post = postService.findById(id);
		model.addAttribute("post", post);
		List<Category> categorys = cateService.findAll();
		List<User> users = userService.findAll();
		model.addAttribute("allCategory", categorys);
		model.addAttribute("allUser", users);
		return "admin/edit-post";
	}
	
	@RequestMapping("admin/post/delete/{id}")
	public String deletePost(@PathVariable("id") int id) {
		Post post = postService.findById(id);
		postService.delete(post);
		return "redirect:/admin/post-management/list";
	}

	@PostMapping("admin/post/create")
	public String createPost(@ModelAttribute("post") Post post) {
		postService.save(post);
//		return "redirect:/admin/post-management/list";
		return "admin/post-list";
	}
}
