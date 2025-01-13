package com.example.demo.entities;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	@Column(name = "book_id", nullable = false)
	private Integer id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "publisher", nullable = true)
	private String publisher;
	
	@Column(name = "publishedYear", nullable = true)
	private String publishedYear;
	
	@Column(name = "description", nullable = true)
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "author_id", nullable = true)
	private Author author;

	@ManyToMany
	@JoinTable(name = "book_themes_map", // Join table name
			joinColumns = @JoinColumn(name = "book_id"), // Foreign key for Book
			inverseJoinColumns = @JoinColumn(name = "theme_id") // Foreign key for Theme
	)
	private List<Theme> themes;
	
	public Book() {
		
	}

	public Book(int id, String title, Author author, String publisher, String publishedYear, String description) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.publishedYear = publishedYear;
		this.description = description;
	}

	public void addATheme(Theme theme) {
		themes.add(theme);
	}
	
	public void deleteTheme(int themeId) {
		 Optional<Theme> themeToDelete = themes.stream()
                 .filter(theme -> theme.getId() == themeId)
                 .findFirst();
		 
		 if (themeToDelete.isPresent()) {
	            themes.remove(themeToDelete.get());
	        }
	}

	public String toString() {
		return "~~~~" + title + "~~~~\n" + "Author: " + author.getFirstName() + " " + author.getLastName() + "\n" + "Description: " + description + "\n"
				+ "Publisher: " + publisher + "\n" + "Published Year: " + publishedYear + "\n" + "Themes" + themes + "\n";
	}

	// GETTERS AND SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublishedYear() {
		return publishedYear;
	}

	public void setPublishedYear(String publishedYear) {
		this.publishedYear = publishedYear;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Theme> getThemes() {
		return themes;
	}

	public void setThemes(List<Theme> themes) {
		this.themes = themes;
	}

}
