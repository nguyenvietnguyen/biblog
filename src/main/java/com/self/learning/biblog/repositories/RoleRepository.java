package com.self.learning.biblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.self.learning.biblog.models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	@Query("select r from Role r where r.name = :name")
	public Role getRoleByName(@Param("name") String name);
}
