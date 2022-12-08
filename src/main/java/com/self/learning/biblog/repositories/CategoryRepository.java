package com.self.learning.biblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.self.learning.biblog.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
