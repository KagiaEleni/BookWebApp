package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Book;
import com.example.demo.entities.LendBook;

@Service
public class LendBookService {

	private static List<LendBook> borrowedBooks = new ArrayList<LendBook>();

	// Get all LendBooks
	public List<LendBook> getAllLendBooks() {
		return borrowedBooks;
	}

	// The user borrows a book
	public List<LendBook> borrowBook(int userId, int bookId) {
		if (BookService.findBookById(bookId) && PersonService.findUserById(userId))
			borrowedBooks.add(new LendBook(PersonService.getUserById(userId), BookService.returnBookById(bookId)));
		
		return borrowedBooks;
	}

	// The user returns a book
	public List<LendBook> returnBook(int userId, int bookId) {
		Optional<LendBook> userWhoReturns = borrowedBooks.stream().filter(user -> user.getUser().getId() == userId)
				.filter(book -> book.getBorrowedBook().getId() == bookId).findFirst();

		if (userWhoReturns.isPresent()) {
			borrowedBooks.remove(userWhoReturns.get());
		}
		
		return borrowedBooks;

	}

	// The book is deleted
	public static void removeBookFromAll(int bookId) {
		borrowedBooks.removeIf(lendBook -> lendBook.getBorrowedBook().getId() == bookId);

	}

}
