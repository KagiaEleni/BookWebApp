package com.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.entities.Author;
import com.example.entities.Book;

@Service
public class BookService {

	/*
	 * @Autowired
	 * AuthorServices authorService
	 * @Autowired
	 * ThemeServices themeService
	 */
	private static List<Book> books = new ArrayList<Book>();

	// Add Book
	public void addBook(Book book) {
		books.add(book);
		this.getAllBooks();
	}
	
	//Find a book by ID
		public static boolean findBookById(int id) {
	        Book b = books.stream()
	                    .filter(book -> book.getId() == id)
	                    .findFirst()
	                    .orElse(null);
	        
	        if (b != null){
	            return true;
	        }
	        else {
	            System.out.println("Invalid id");
	            return false;
	        }
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
			LendBookService.removeBookFromAll(bookToDelete.get().getId());
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
