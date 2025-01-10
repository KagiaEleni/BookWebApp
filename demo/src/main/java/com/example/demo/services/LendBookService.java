package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.LendBook;
import com.example.demo.repositories.LendBookRepository;

@Service
public class LendBookService {

	@Autowired
	PersonService personService;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	LendBookRepository repository;
	//private static List<LendBook> borrowedBooks = new ArrayList<LendBook>();

	// Get all LendBooks
	public List<LendBook> getAllLendBooks() {
		return repository.findAll();
	}

	// The user borrows a book
	public List<LendBook> borrowBook(int userId, int bookId) {
		if (bookService.findBookById(bookId) && personService.findUserById(userId))
			repository.save(new LendBook(personService.getUserById(userId), bookService.returnBookById(bookId)));
		
		return this.getAllLendBooks();
	}

	// The user returns a book
	public List<LendBook> returnBook(int userId, int bookId) {
		Optional<LendBook> userWhoReturns = repository.findAll().stream().filter(user -> user.getUser().getId() == userId)
				.filter(book -> book.getBorrowedBook().getId() == bookId).findFirst();

		if (userWhoReturns.isPresent()) {
			repository.delete(userWhoReturns.get());
		}
		
		return this.getAllLendBooks();

	}

	// The book is deleted
	public void removeBookFromAll(int bookId) {
		repository.findAll().removeIf(lendBook -> lendBook.getBorrowedBook().getId() == bookId);

	}

}
