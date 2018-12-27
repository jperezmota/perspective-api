package com.jonathanperez.perspective.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jonathanperez.perspective.entities.Author;
import com.jonathanperez.perspective.exception.ResourceNotFoundException;
import com.jonathanperez.perspective.repository.AuthorRepository;
import com.jonathanperez.perspective.util.UserSessionUtil;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public Author getAuthor(long id) {
		try {
			return authorRepository.getAuthor(id, UserSessionUtil.getUsername());
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException("Author", "Id", id);
		}
	}

	@Override
	public List<Author> getAuthors() {
		return authorRepository.getAuthors(UserSessionUtil.getUsername());
	}

	@Override
	public void createAuthor(Author author) {
		boolean authorNameAlreadyExists = verifyUserAuthorNameExistance(author.getName(), UserSessionUtil.getUsername());
		if(authorNameAlreadyExists) {
			throw new ValidationException("Author name: " + author.getName() + ", already exists.");
		}
		
		authorRepository.saveAuthor(author);
	}

	@Override
	public Author updateAuthor(Author author, long id) {
		try {			
			String username =  UserSessionUtil.getUsername();
			Author existingAuthor = authorRepository.getAuthor(id, username);

			boolean authorNameAlreadyExists = verifyUserAuthorNameExistance(author.getName(), username, id);
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
			Author author = authorRepository.getAuthor(id, UserSessionUtil.getUsername());	
			author.setDeleted(true);
			author.setDeletedBy("admin");
			author.setDeletedDate(new Date());
			authorRepository.updateAuthor(author);
	 	}catch(EmptyResultDataAccessException ex) {
	 		throw new ResourceNotFoundException("Author", "Id", id);
	 	}
	}

	@Override
	public boolean verifyUserAuthorNameExistance(String name, String username) {
		try{
			authorRepository.findUserAuthorByName(name, username);
			return true;
		}catch(EmptyResultDataAccessException ex) {
	 		return false;
	 	}	
	}

	@Override
	public boolean verifyUserAuthorNameExistance(String name, String username, long idToExclude) {
		try{
			authorRepository.findUserAuthorByName(name, username, idToExclude);
			return true;
		}
		catch(EmptyResultDataAccessException ex) {
	 		return false;
	 	}	
	}

}
