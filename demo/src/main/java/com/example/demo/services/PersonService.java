package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Person;
import com.example.demo.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository repository;
	//private static List<Person> users = new ArrayList<Person>();

	// Get all users
	public List<Person> getAllUsers() {
		return repository.findAll();
	}

	// Find a person by ID
	public boolean findUserById(int id) {
		Person u = repository.findAll().stream().filter(user -> user.getId() == id).findFirst().orElse(null);

		if (u != null) {
			return true;
		} else {
			System.out.println("Invalid id");
			return false;
		}
	}

	// Get user by Id
	public Person getUserById(int userId) {
		Optional<Person> userById = repository.findAll().stream().filter(user -> user.getId() == userId).findFirst();

		if (userById.isPresent()) {
			return userById.get();
		}

		return null;
	}

	// Update user
	public List<Person> updateUser(int id, String firstName, String lastName) {

		for (Person user : repository.findAll()) {
			if (user.getId() == id) {
				if (firstName != null)
					user.setFirstName(firstName);
				if (lastName != null)
					user.setLastName(lastName);
			}
		}
		return this.getAllUsers();
	}

	// Delete user
	public List<Person> deleteUser(int userId) {
		Optional<Person> userToDelete = repository.findAll().stream().filter(user -> user.getId() == userId).findFirst();

		if (userToDelete.isPresent()) {
			repository.delete(userToDelete.get());
		}
		return this.getAllUsers();
	}

	// Add user
	public List<Person> addUser(Person user) {
		repository.save(user);
		return this.getAllUsers();
	}

}
