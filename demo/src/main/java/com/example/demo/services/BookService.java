package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Author;
import com.example.demo.entities.Book;

@Service
public class BookService {

	/*
	 * @Autowired AuthorServices authorService
	 * 
	 * @Autowired ThemeServices themeService
	 */
	private static List<Book> books = new ArrayList<Book>();

	// Add Book
	public List<Book> addBook(Book book) {
		books.add(book);
		return books;
	}

	// Find a book by ID
	public static boolean findBookById(int id) {
		Book b = books.stream().filter(book -> book.getId() == id).findFirst().orElse(null);

		if (b != null) {
			return true;
		} else {
			System.out.println("Invalid id");
			return false;
		}
	}

	// Return a book by ID
	public static Book returnBookById(int id) {
		Book b = books.stream().filter(book -> book.getId() == id).findFirst().orElse(null);

		if (b != null) {
			return b;
		} else {
			System.out.println("Invalid id");
			return null;
		}
	}

	// Return all Books
	public List<Book> getAllBooks() {
		return books;
	}

	// Delete Book
	public List<Book> deleteBook(int id) {
		Optional<Book> bookToDelete = books.stream().filter(books -> books.getId() == id).findFirst();

		if (bookToDelete.isPresent()) {
			books.remove(bookToDelete.get());
			LendBookService.removeBookFromAll(bookToDelete.get().getId());
		}
		return books;
	}

	// Update Book
	public List<Book> updateBook(int id, String title, Author author, String publisher, String publishedYear,
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
		return books;

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

	// Remove a theme from a book
	public static void removeTheme(int themeId) {
		for (Book book : books) {
			book.deleteTheme(themeId);
		}
	}

	// Remove an author from a book
	public static void removeAuthor(int authorId) {
		for (Book book : books) {
			if (book.getAuthor().getId() == authorId)
				book.setAuthor(null);
		}
	}

}
