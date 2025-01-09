package com.example.demo.entities;

public class Author {
	
	private int id;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	public Author(int id, String firstName, String lastName, String dateOfBirth) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}
	
	public String toString() {
        return "~~~~" + firstName + lastName + "~~~~\n" +
                "Date of birth: " + dateOfBirth + "\n";
    }
	
	//GETTERS AND SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	

}
