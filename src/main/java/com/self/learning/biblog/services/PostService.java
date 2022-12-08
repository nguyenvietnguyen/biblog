package com.self.learning.biblog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.self.learning.biblog.models.Post;
import com.self.learning.biblog.repositories.PostRepository;

@Service
@Transactional
public class PostService {
	@Autowired
	private PostRepository postRepo;
	
	public void save(Post Post) {
		postRepo.save(Post);
	}
	
	public List<Post> findAll(){
		return postRepo.findAll();
	}
	
	public void delete(Post Post) {
		postRepo.delete(Post);
	}
	
	public Post findById(int id) {
		return postRepo.findById(id).get();
	}
}
