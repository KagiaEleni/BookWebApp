package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Person;
import com.example.demo.services.PersonService;

@RestController
@RequestMapping("persons")
public class PersonController {
	@Autowired
	PersonService userService;
	
	@GetMapping("/allPersons")
	public List<Person> getAllPersons() {
		return userService.getAllUsers();
	}
	
	@PostMapping("/addPerson")
	public List<Person> addPersons(@RequestBody Person person){
		return userService.addUser(person);
	}
	
	@DeleteMapping("/deletePerson")
	public List<Person> deletePerson(@RequestParam Integer id){
		return userService.deleteUser(id);
	}
	
	@PutMapping("/putPerson")
	public List<Person> putPerson(@RequestBody Person person) {
		return userService.updateUser(person.getId(), person.getFirstName(), person.getLastName());
	}
}
