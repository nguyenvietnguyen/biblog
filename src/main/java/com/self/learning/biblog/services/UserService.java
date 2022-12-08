package com.self.learning.biblog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.self.learning.biblog.models.User;
import com.self.learning.biblog.repositories.UserRepository;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserRepository userRepo;

	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public void save(User user) {
		userRepo.save(user);
	}
	
	public List<User> findAll(){
		return userRepo.findAll();
	}
	
	public void delete(User user) {
		userRepo.delete(user);
	}
	
	public User findById(int id) {
		return userRepo.findById(id).get();
	}
	
	public User findByUsername(String username) {
		return userRepo.getUserByUserName(username);
	}
	
	public User findByEmail(String email) {
		return userRepo.getUserByEmail(email);
	}
	
	public void register(User user) throws Exception {
		if(findByUsername(user.getUsername()) != null) {
			throw new Exception("username already exists");
		}
		if(findByEmail(user.getEmail()) != null) {
			throw new Exception("email already exists");
		}
		String passwordEncode = passwordEncoder.encode(user.getPassword());
		user.setPassword(passwordEncode);
		save(user);
	}
}
