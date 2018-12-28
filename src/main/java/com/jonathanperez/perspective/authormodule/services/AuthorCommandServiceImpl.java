package com.jonathanperez.perspective.authormodule.services;

import java.util.Date;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jonathanperez.perspective.authormodule.entities.Author;
import com.jonathanperez.perspective.authormodule.repositories.AuthorCommandRepository;
import com.jonathanperez.perspective.sharedmodule.exceptions.ResourceNotFoundException;
import com.jonathanperez.perspective.sharedmodule.session.UserSessionUtil;

@Service
@Transactional
public class AuthorCommandServiceImpl implements AuthorCommandService {
	
	@Autowired
	private AuthorCommandRepository authorRepository;
	@Autowired
	private AuthorQueryService authorQueryService;

	@Override
	public void createAuthor(Author author) {
		boolean authorNameAlreadyExists = authorQueryService.verifyUserAuthorNameExistance(author.getName(), UserSessionUtil.getUsername());
		if(authorNameAlreadyExists) {
			throw new ValidationException("Author name: " + author.getName() + ", already exists.");
		}
		
		authorRepository.saveAuthor(author);
	}

	@Override
	public Author updateAuthor(Author author, long id) {
		try {			
			String username =  UserSessionUtil.getUsername();
			Author existingAuthor = authorQueryService.getAuthor(id);

			boolean authorNameAlreadyExists = authorQueryService.verifyUserAuthorNameExistance(author.getName(), username, id);
			if(authorNameAlreadyExists) {
				throw new ValidationException("Author name: " + author.getName() + ", already exists.");
			}
			
			existingAuthor.setName(author.getName());
			authorRepository.updateAuthor(existingAuthor);
			
			return existingAuthor;
		}catch(EmptyResultDataAccessException ex) {
	 		throw new ResourceNotFoundException("Author", "Id", id);
	 	}
	}

	@Override
	public void deleteAuthor(long id) {
		try {
			Author author = authorQueryService.getAuthor(id);	
			author.setDeleted(true);
			author.setDeletedBy("admin");
			author.setDeletedDate(new Date());
			authorRepository.updateAuthor(author);
	 	}catch(EmptyResultDataAccessException ex) {
	 		throw new ResourceNotFoundException("Author", "Id", id);
	 	}
	}

}
