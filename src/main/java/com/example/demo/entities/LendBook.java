package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "lendBooks")
public class LendBook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	@Column(name = "lend_id", nullable = false)
	private int lend_id;
	
	@ManyToOne
	@JoinColumn(name = "person_id", nullable = true)
	private Person user;
	
	@ManyToOne
	@JoinColumn(name = "book_id", nullable = true)
	private Book borrowedBook;
	
	public LendBook() {

	}

	public LendBook(int id, Person user, Book borrowedBook) {
		this.lend_id = id;
		this.user = user;
		this.borrowedBook = borrowedBook;
	}

	@Override
	public String toString() {
		return "LendBook [user=" + user.getFirstName() + " " + user.getLastName() + "Borrowed Book: "
				+ borrowedBook.getTitle() + "]\n";
	}

	// GETTERS AND SETTERS
	public Person getUser() {
		return user;
	}

	public void setUser(Person user) {
		this.user = user;
	}

	public Book getBorrowedBook() {
		return borrowedBook;
	}

	public void setBorrowedBook(Book borrowedBook) {
		this.borrowedBook = borrowedBook;
	}

}
