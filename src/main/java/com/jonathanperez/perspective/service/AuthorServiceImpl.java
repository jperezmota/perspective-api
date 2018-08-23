package com.jonathanperez.perspective.service;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonathanperez.perspective.entities.Author;
import com.jonathanperez.perspective.repository.AuthorRepository;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public Author getAuthor(long id) {
		return authorRepository.getAuthor(id);
	}

}
