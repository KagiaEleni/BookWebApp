package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Book {

	private int id;
	private String title;
	private Author author;
	private String publisher;
	private String publishedYear;
	private String description;
	private List<Theme> themes = new ArrayList<Theme>();

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
