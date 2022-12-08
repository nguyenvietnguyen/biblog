package com.self.learning.biblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.self.learning.biblog.models.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer>{

}
