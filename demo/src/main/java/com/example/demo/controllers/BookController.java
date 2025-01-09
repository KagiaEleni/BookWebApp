package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Book;
import com.example.demo.services.BookService;

public class BookController {

	@Autowired
	BookService bookService;
	
	@GetMapping("/allBooks")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@PostMapping("/addBook")
	public List<Book> addBooks(@RequestBody Book book){
		return bookService.addBook(book);
	}
	
	@DeleteMapping("/deleteBook")
	public List<Book> deleteBook(@RequestParam Integer id){
		return bookService.deleteBook(id);
	}
	
	@PutMapping("/putBook")
	public List<Book> putBook(@RequestBody Book book) {
		return bookService.updateBook(book.getId(), book.getTitle(), book.getAuthor(), book.getPublisher(), book.getPublishedYear(), book.getDescription());
	}
}
