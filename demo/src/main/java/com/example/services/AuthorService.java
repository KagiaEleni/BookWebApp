package com.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.entities.Author;

@Service
public class AuthorService {
	
	private List<Author> authors = new ArrayList<Author>();
	
	//Return all Authors
	public List<Author> getAllAuthors() {
		return authors;
	}
	
	//Find an author by ID
	public Author findAuthorById(int id) {
        Author a = authors.stream()
                    .filter(author -> author.getId() == id)
                    .findFirst()
                    .orElse(null);
        
        if (a != null){
            return a;
        }
        else {
            System.out.println("Invalid id");
            return null;
        }
    }
	
	//Add an author
	public void addAuthor(Author author) {
		authors.add(author);
		this.getAllAuthors();
	}
	
	//Delete an author
	public void deleteAuthor(Author author) {
		Optional<Author> authorToDelete = authors.stream()
                .filter(authors -> authors.getId() == author.getId())
                .findFirst();

		if (authorToDelete.isPresent()) {
			authors.remove(authorToDelete.get());
		}
		this.getAllAuthors();
	} 
	
	//Update an Author
	public void updateAuthor(int id, String firstName, String lastName, String DateOfBirth) {
		for(Author author: authors) {
			if(author.getId() == id) {
				if (firstName != null)
					author.setFirstName(firstName);
				if (lastName != null)
					author.setLastName(lastName);
				if (DateOfBirth != null)
					author.setDateOfBirth(DateOfBirth);
			}
		}
		this.getAllAuthors();
	}

}
