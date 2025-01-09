package com.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.entities.Person;

@Service
public class PersonService {

	private static List<Person> users = new ArrayList<Person>();

	// Get all users
	public List<Person> getAllUsers() {
		return users;
	}

	// Find a person by ID
	public static boolean findUserById(int id) {
		Person u = users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);

		if (u != null) {
			return true;
		} else {
			System.out.println("Invalid id");
			return false;
		}
	}

	// Get user by Id
	public static Person getUserById(int userId) {
		Optional<Person> userById = users.stream().filter(user -> user.getId() == userId).findFirst();

		if (userById.isPresent()) {
			return userById.get();
		}

		return null;
	}

	// Update user
	public void updateUser(int id, String firstName, String lastName) {

		for (Person user : users) {
			if (user.getId() == id) {
				if (firstName != null)
					user.setFirstName(firstName);
				if (lastName != null)
					user.setLastName(lastName);
			}
		}
	}

	// Delete user
	public void deleteUser(int userId) {
		Optional<Person> userToDelete = users.stream().filter(user -> user.getId() == userId).findFirst();

		if (userToDelete.isPresent()) {
			users.remove(userToDelete.get());
		}
	}

	// Add user
	public void addUser(Person user) {
		users.add(user);
	}

}
