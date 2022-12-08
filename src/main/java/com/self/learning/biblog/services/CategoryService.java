package com.self.learning.biblog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.self.learning.biblog.models.Category;
import com.self.learning.biblog.repositories.CategoryRepository;

@Service
@Transactional
public class CategoryService {
	@Autowired
	private CategoryRepository cateRepo;
	
	public void save(Category category) {
		cateRepo.save(category);
	}
	
	public List<Category> findAll(){
		return cateRepo.findAll();
	}
	
	public void delete(Category category) {
		cateRepo.delete(category);
	}
	
	public Category findById(int id) {
		return cateRepo.findById(id).get();
	}
}
