package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Author;
import com.example.demo.entities.Book;
import com.example.demo.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	AuthorService authorService;

	@Autowired
	ThemeService themeService;
	
	@Autowired
	LendBookService lendBookService;

	// private static List<Book> books = new ArrayList<Book>();

	@Autowired
	BookRepository repository;

	// Add Book
	public List<Book> addBook(Book book) {
		repository.save(book);
		return this.getAllBooks();
	}

	// Find a book by ID
	public boolean findBookById(int id) {
		Book b = repository.findAll().stream().filter(book -> book.getId() == id).findFirst().orElse(null);

		if (b != null) {
			return true;
		} else {
			System.out.println("Invalid id");
			return false;
		}
	}

	// Return a book by ID
	public Book returnBookById(int id) {
		Book b = repository.findAll().stream().filter(book -> book.getId() == id).findFirst().orElse(null);

		if (b != null) {
			return b;
		} else {
			System.out.println("Invalid id");
			return null;
		}
	}

	// Return all Books
	public List<Book> getAllBooks() {
		return repository.findAll();
	}

	// Delete Book
	public List<Book> deleteBook(int id) {
		Optional<Book> bookToDelete = repository.findAll().stream().filter(books -> books.getId() == id).findFirst();

		if (bookToDelete.isPresent()) {
			repository.delete(bookToDelete.get());
			lendBookService.removeBookFromAll(bookToDelete.get().getId());
		}
		return this.getAllBooks();
	}

	// Update Book
	public List<Book> updateBook(int id, String title, Author author, String publisher, String publishedYear,
			String description) {

		for (Book book : repository.findAll()) {
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
		return this.getAllBooks();

	}

	// Change Author
	public void updateBookAuthor(int bookId, int authorId, AuthorService aService) {

		AuthorService author = aService;

		for (Book book : repository.findAll()) {
			if (book.getId() == bookId) {
				book.setAuthor(author.findAuthorById(authorId));
			}
		}
	}

	// Add a theme to a book
	public List<Book> addTheme(int bookId, int themeID) {
		for (Book book : repository.findAll()) {
			if (book.getId() == bookId) {
				book.addATheme(themeService.findThemeById(themeID));
			}
		}

		return this.getAllBooks();
	}

	// Remove a theme from a book
	public void removeTheme(int themeId) {
		for (Book book : repository.findAll()) {
			book.deleteTheme(themeId);
		}
	}

	// Remove an author from a book
	public void removeAuthor(int authorId) {
		for (Book book : repository.findAll()) {
			if (book.getAuthor().getId() == authorId)
				book.setAuthor(null);
		}
	}

}
