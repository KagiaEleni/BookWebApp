package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entities.*;
import com.example.services.*;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		ThemeService thService = new ThemeService();
		AuthorService aService = new AuthorService();
		BookService bService = new BookService();
		
		Theme th1 = new Theme(1,"Adventure","descr1");
		Theme th2 = new Theme(2,"Horror","descr2");
		Theme th3 = new Theme(3,"Comedy","descr3");
		
		Author a1 = new Author(1, "Nikos", "Pappas", "8/1/2000");
		Author a2 = new Author(2, "Maria", "Pappa", "9/1/2000");
		Author a3 = new Author(3, "Dimitris", "Pappas", "10/1/2000");
		
		Book b1 = new Book(1, "First Book", a1, "Ekdoseis", "10/1/2025", "bookDescr1");
		Book b2 = new Book(2, "Second Book", a2, "Ekdoseis", "11/1/2025", "bookDescr2");
		Book b3 = new Book(3, "Third Book", a3, "Ekdoseis", "12/1/2025", "bookDescr3");
		Book b4 = new Book(4, "Fourth Book", a3, "Ekdoseis", "13/1/2025", "bookDescr4");
		
		thService.addTheme(th1);
		thService.addTheme(th2);
		thService.addTheme(th3);
		
		aService.addAuthor(a1);
		aService.addAuthor(a2);
		aService.addAuthor(a3);
		
		bService.addBook(b1);
		bService.addBook(b2);
		bService.addBook(b3);
		bService.addBook(b4);
		
		System.out.println("____________________Themes____________________");
		System.out.println(thService.getAllThemes());
		System.out.println("____________________Authors____________________");
		System.out.println(aService.getAllAuthors());
		System.out.println("____________________Books____________________");
		System.out.println(bService.getAllBooks());
		
		bService.deleteBook(b4);
		
		System.out.println("____________________Book 4 Deleted____________________");
		System.out.println(bService.getAllBooks());
		
		bService.updateBook(1, null, a2, null, null, null);
		System.out.println("____________________Book 1 Updated____________________");
		System.out.println(bService.getAllBooks());
		
		bService.addTheme(1, 1, thService);
		bService.addTheme(1, 2, thService);
		bService.addTheme(2, 2, thService);
		bService.addTheme(3, 3, thService);
		bService.addTheme(3, 1, thService);
		
		System.out.println("____________________Themes Added____________________");
		System.out.println(bService.getAllBooks());
		
		bService.updateBookAuthor(1, 1, aService);
		
		System.out.println("____________________Change Book Author____________________");
		System.out.println(bService.getAllBooks());
		
		thService.deleteTheme(th1);
		System.out.println("____________________Delete Theme____________________");
		System.out.println(thService.getAllThemes());
		System.out.println(bService.getAllBooks());
		

	}

}
