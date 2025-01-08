package com.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.entities.Author;
import com.example.entities.Book;
import com.example.entities.Theme;

public class BookService {

	private List<Book> books = new ArrayList<Book>();

	// Add Book
	public void addBook(Book book) {
		books.add(book);
		this.getAllBooks();
	}

	// Return all Books
	public List<Book> getAllBooks() {
		return books;
	}

	// Delete Book
	public void deleteBook(Book book) {
		Optional<Book> bookToDelete = books.stream().filter(books -> books.getId() == book.getId()).findFirst();

		if (bookToDelete.isPresent()) {
			books.remove(bookToDelete.get());
		}
		this.getAllBooks();
	}

	// Update Book
	public void updateBook(int id, String title, Author author, String publisher, String publishedYear,
			String description) {

		for (Book book : books) {
			if (book.getId() == id) {
				if (title != null)
					book.setTitle(title);
				if (author != null)
					book.setAuthor(author);
				if (publisher != null)
					book.setPublisher(publisher);
				if (publishedYear != null)
					book.setPublishedYear(publishedYear);
				if (description != null)
					book.setDescription(description);
			}
		}
		this.getAllBooks();

	}

	// Change Author
	public void updateBookAuthor(int bookId, int authorId, AuthorService aService) {

		AuthorService author = aService;

		for (Book book : books) {
			if (book.getId() == bookId) {
				book.setAuthor(author.findAuthorById(authorId));
			}
		}
	}


	// Add a theme to a book
	public void addTheme(int bookId, int themeID, ThemeService themeService) {

		ThemeService theme = themeService;

		for (Book book : books) {
			if (book.getId() == bookId) {
				book.addATheme(theme.findThemeById(themeID));
			}
		}
	}

}
