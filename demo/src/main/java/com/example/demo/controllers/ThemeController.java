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

import com.example.demo.entities.Book;
import com.example.demo.entities.Theme;
import com.example.demo.services.BookService;
import com.example.demo.services.ThemeService;

@RestController
@RequestMapping("themes")
public class ThemeController {
	
	@Autowired
	ThemeService themeService;

	@GetMapping("/hello")
	public String hello() {
		return "Hello from Theme controller";
	}
	
	@GetMapping("/allThemes")
	public List<Theme> getAllThemes() {
		return themeService.getAllThemes();
	}
	
	@PostMapping("/addTheme")
	public List<Theme> addThemes(@RequestBody Theme theme){
		return themeService.addTheme(theme);
	}
	
	@DeleteMapping("/deleteTheme")
	public List<Theme> deleteTheme(@RequestParam Integer id){
		return themeService.deleteTheme(id);
	}
	
	@PutMapping("/putTheme")
	public List<Theme> putTheme(@RequestBody Theme theme) {
		return themeService.updateTheme(theme.getId(), theme.getName(), theme.getDescription());
	}
	
}
