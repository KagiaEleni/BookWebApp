package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.entities.Book;
import com.example.entities.Theme;

public class BookService {
	
	private List<Book> books = new ArrayList<Book>();
	
	//Add Book
	public void addBook(Book book) {
		books.add(book);
	}
	
	//Print Books
	public void printBooks() {
		for(Book book: books) {
			System.out.println("Book Title: " + book.getTitle());
			System.out.println("Book Author: " + book.getAuthor());
		}
	}
	
	//Delete Book
	public void deleteBook(Book book) {
		Optional<Book> bookToDelete = books.stream()
                .filter(books -> books.getId() == book.getId())
                .findFirst();

		if (bookToDelete.isPresent()) {
			books.remove(bookToDelete.get());
		}
	}

	//Update Book
	public void updateBook(Book changedBook) {

		for(Book book: books) {
			if(book.getId() == changedBook.getId()) {
				book.setTitle(changedBook.getTitle());
				book.setAuthor(changedBook.getAuthor());
				book.setDescription(changedBook.getDescription());
				book.setPublishedYear(changedBook.getPublishedYear());
				book.setPublisher(changedBook.getPublisher());
				book.setThemes(changedBook.getThemes());
			}
		}
		
	}
	
	//Add a theme to a book
	public void addTheme(Book book1, Theme theme) {
		for(Book book: books) {
			if(book.getId() == book1.getId()) {
				book.addATheme(theme);
			}
		}
	}

}
