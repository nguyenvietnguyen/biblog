package com.self.learning.biblog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.self.learning.biblog.models.User;
import com.self.learning.biblog.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepo.getUserByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		return new CustomUserDetails(user);
	}

}
