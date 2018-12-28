package com.jonathanperez.perspective.authormodule.services;

import java.util.Date;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonathanperez.perspective.authormodule.entities.Author;
import com.jonathanperez.perspective.authormodule.repositories.AuthorCommandRepository;

@Service
@Transactional
public class AuthorCommandServiceImpl implements AuthorCommandService {

	@Autowired
	private AuthorCommandRepository authorRepository;
	@Autowired
	private AuthorQueryService authorQueryService;

	@Override
	public void createAuthor(Author author, String username) {
		boolean authorNameAlreadyExists = authorQueryService.verifyUserAuthorNameExistance(author.getName(),
				username);
		if (authorNameAlreadyExists) {
			throw new ValidationException("Author name: " + author.getName() + ", already exists.");
		}

		authorRepository.saveAuthor(author);
	}

	@Override
	public Author updateAuthor(Author author, long id, String username) {
		Author existingAuthor = authorQueryService.getAuthor(id, username);

		boolean authorNameAlreadyExists = authorQueryService.verifyUserAuthorNameExistance(author.getName(), username,
				id);
		if (authorNameAlreadyExists) {
			throw new ValidationException("Author name: " + author.getName() + ", already exists.");
		}

		existingAuthor.setName(author.getName());
		authorRepository.updateAuthor(existingAuthor);

		return existingAuthor;
	}

	@Override
	public void deleteAuthor(long id, String username) {
		Author author = authorQueryService.getAuthor(id, username);
		author.setDeleted(true);
		author.setDeletedBy(username);
		author.setDeletedDate(new Date());
		authorRepository.updateAuthor(author);
	}

}
