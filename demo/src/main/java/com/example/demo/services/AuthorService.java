package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Author;
import com.example.demo.repositories.AuthorRepository;

@Service
public class AuthorService {

	@Autowired 
	AuthorRepository repository;
	//private List<Author> authors = new ArrayList<Author>();

	// Return all Authors
	public List<Author> getAllAuthors() {
		return repository.findAll();
	}

	// Find an author by ID
	public Author findAuthorById(int id) {
		Author a = repository.findAll().stream().filter(author -> author.getId() == id).findFirst().orElse(null);

		if (a != null) {
			return a;
		} else {
			System.out.println("Invalid id");
			return null;
		}
	}

	// Add an author
	public List<Author> addAuthor(Author author) {
		repository.save(author);
		return this.getAllAuthors();
	}

	// Delete an author
	public List<Author> deleteAuthor(int id) {
		Optional<Author> authorToDelete = repository.findAll().stream().filter(authors -> authors.getId() == id).findFirst();

		if (authorToDelete.isPresent()) {
			repository.delete(authorToDelete.get());
		}
		return this.getAllAuthors();
	}

	// Update an Author
	public List<Author> updateAuthor(int id, String firstName, String lastName, String DateOfBirth) {
		for (Author author : repository.findAll()) {
			if (author.getId() == id) {
				if (firstName != null)
					author.setFirstName(firstName);
				if (lastName != null)
					author.setLastName(lastName);
				if (DateOfBirth != null)
					author.setDateOfBirth(DateOfBirth);
			}
		}
		return this.getAllAuthors();
	}

}
