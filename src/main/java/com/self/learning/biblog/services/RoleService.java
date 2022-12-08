package com.self.learning.biblog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.self.learning.biblog.models.Role;
import com.self.learning.biblog.repositories.RoleRepository;

@Service
@Transactional
public class RoleService {
	@Autowired
	private RoleRepository roleRepo;
	
	public void save(Role role) {
		roleRepo.save(role);
	}
	
	public List<Role> findAll(){
		return roleRepo.findAll();
	}
	
	public void delete(Role role) {
		roleRepo.delete(role);
	}
	
	public Role findById(int id) {
		return roleRepo.findById(id).get();
	}
	
	public Role findByName(String name) {
		return roleRepo.getRoleByName(name);
	}
}
