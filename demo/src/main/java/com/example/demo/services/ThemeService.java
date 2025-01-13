package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Theme;
import com.example.demo.repositories.ThemeRepository;

@Service
public class ThemeService {

//	@Autowired
//	BookService bookService;
	
	@Autowired
	ThemeRepository repository;
	//private static List<Theme> themes = new ArrayList<Theme>();

	// Return all Themes
	public List<Theme> getAllThemes() {
		return repository.findAll();
	}

	// Add theme
	public List<Theme> addTheme(Theme theme) {
		repository.save(theme);
		return this.getAllThemes();
	}

//	// Delete theme
//	public List<Theme> deleteTheme(int id) {
//		Optional<Theme> themeToDelete = repository.findAll().stream().filter(themes -> themes.getId() == id).findFirst();
//
//		if (themeToDelete.isPresent()) {
//			repository.delete(themeToDelete.get());
//			bookService.removeTheme(id);
//		}
//		return this.getAllThemes();
//	}

	// Update theme
	public List<Theme> updateTheme(int id, String name, String description) {
		for (Theme theme : repository.findAll()) {
			if (theme.getId() == id) {
				if (name != null)
					theme.setName(name);
				if (description != null)
					theme.setDescription(description);
			}
		}
		return repository.findAll();
	}

	public Theme findThemeById(int id) {
		Theme t = repository.findAll().stream().filter(theme -> theme.getId() == id).findFirst().orElse(null);

		if (t != null) {
			return t;
		} else {
			System.out.println("Invalid id");
			return null;
		}
	}

}