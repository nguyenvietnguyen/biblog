package com.self.learning.biblog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.self.learning.biblog.models.Tag;
import com.self.learning.biblog.repositories.TagRepository;

@Service
@Transactional
public class TagService {
	@Autowired
	private TagRepository tagRepo;

	public void save(Tag tag) {
		tagRepo.save(tag);
	}

	public List<Tag> findAll() {
		return tagRepo.findAll();
	}

	public void delete(Tag tag) {
		tagRepo.delete(tag);
	}

	public Tag findById(int id) {
		return tagRepo.findById(id).get();
	}
}
