package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.LendBook;
import com.example.demo.services.LendBookService;

@RestController
@RequestMapping("lendBooks")
public class LendBookController {
	
	@Autowired
	LendBookService lendBookService;
	
	@GetMapping("/allLendBooks")
	public List<LendBook> getAllLendBooks() {
		return lendBookService.getAllLendBooks();
	}
	
	@PostMapping("/addLendBook")
	public List<LendBook> addBooks(@RequestParam Integer lendId, Integer userId, Integer bookId){
		return lendBookService.borrowBook(lendId, userId, bookId);
	}
	
	@DeleteMapping("/returnLendBook")
	public List<LendBook> deleteLendBook(@RequestParam Integer userId, Integer bookId){
		return lendBookService.returnBook(userId, bookId);
	}
	
}
