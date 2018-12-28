package com.jonathanperez.perspective.authormodule.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jonathanperez.perspective.authormodule.entities.Author;
import com.jonathanperez.perspective.authormodule.repositories.AuthorQueryRepository;
import com.jonathanperez.perspective.sharedmodule.exceptions.ResourceNotFoundException;

@Service
@Transactional
public class AuthorQueryServiceImpl implements AuthorQueryService {
	
	@Autowired
	private AuthorQueryRepository authorQueryRepository;

	@Override
	public Author getAuthor(long id, String username) {
		try {
			return authorQueryRepository.getAuthor(id, username);
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException("Author", "Id", id);
		}
	}

	@Override
	public List<Author> getAuthors(String username) {
		return authorQueryRepository.getAuthors(username);
	}

	@Override
	public boolean verifyUserAuthorNameExistance(String name, String username) {
		try{
			authorQueryRepository.findUserAuthorByName(name, username);
			return true;
		}catch(EmptyResultDataAccessException ex) {
	 		return false;
	 	}	
	}

	@Override
	public boolean verifyUserAuthorNameExistance(String name, String username, long idToExclude) {
		try{
			authorQueryRepository.findUserAuthorByName(name, username, idToExclude);
			return true;
		}
		catch(EmptyResultDataAccessException ex) {
	 		return false;
	 	}	
	}

}
