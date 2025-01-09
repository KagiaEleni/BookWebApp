package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Author;
import com.example.demo.services.AuthorService;

public class AuthorController {
	
	@Autowired
	AuthorService authorService;
	
	@GetMapping("/allAuthors")
	public List<Author> getAllAuthors() {
		return authorService.getAllAuthors();
	}
	
	@PostMapping("/addAuthor")
	public List<Author> addAuthors(@RequestBody Author author){
		return authorService.addAuthor(author);
	}
	
	@DeleteMapping("/deleteAuthor")
	public List<Author> deleteAuthor(@RequestParam Integer id){
		return authorService.deleteAuthor(id);
	}
	
	@PutMapping("/putAuthor")
	public List<Author> putAuthor(@RequestBody Author author) {
		return authorService.updateAuthor(author.getId(), author.getFirstName(), author.getLastName(), author.getDateOfBirth());
	}

}
