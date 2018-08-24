package com.jonathanperez.perspective.service;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jonathanperez.perspective.dto.AuthorDTO;
import com.jonathanperez.perspective.entities.Author;
import com.jonathanperez.perspective.entities.Category;
import com.jonathanperez.perspective.exception.ResourceNotFoundException;
import com.jonathanperez.perspective.repository.AuthorRepository;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public Author getAuthor(long id) {
		try {
			return authorRepository.getAuthor(id);
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException("Author", "Id", id);
		}
	}

	@Override
	public List<Author> getAuthors() {
		return authorRepository.getAuthors();
	}

	@Override
	public void createAuthor(Author author) {
		author.setCreatedBy("admin");
		author.setCreatedDate(new Date());
		authorRepository.saveAuthor(author);
	}

	@Override
	public Author updateAuthor(AuthorDTO authorDTO, long id) {
		try {
			Author author = authorRepository.getAuthor(id);
			author.setName(authorDTO.name);
			author.setLastModifiedBy("admin");
			author.setLastModifiedDate(new Date());
			authorRepository.updateAuthor(author);
			
			return author;
		}catch(EmptyResultDataAccessException ex) {
	 		throw new ResourceNotFoundException("Author", "Id", id);
	 	}
	}

	@Override
	public void deleteAuthor(long id) {
		try {
			Author author = authorRepository.getAuthor(id);	
			author.setDeleted(true);
			author.setDeletedBy("admin");
			author.setDeletedDate(new Date());
			authorRepository.updateAuthor(author);
	 	}catch(EmptyResultDataAccessException ex) {
	 		throw new ResourceNotFoundException("Author", "Id", id);
	 	}
	}

}
