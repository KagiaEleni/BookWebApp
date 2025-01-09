package com.example.entities;

public class LendBook {

	private Person user;
	private Book borrowedBook;

	public LendBook(Person user, Book borrowedBook) {
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
