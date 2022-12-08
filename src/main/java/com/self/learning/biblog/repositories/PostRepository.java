package com.self.learning.biblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.self.learning.biblog.models.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
