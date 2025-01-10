package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Theme;

@Service
public class ThemeService {

	private static List<Theme> themes = new ArrayList<Theme>();

	// Return all Themes
	public List<Theme> getAllThemes() {
		return themes;
	}

	// Add theme
	public List<Theme> addTheme(Theme theme) {
		themes.add(theme);
		return themes;
	}

	// Delete theme
	public List<Theme> deleteTheme(int id) {
		Optional<Theme> themeToDelete = themes.stream().filter(themes -> themes.getId() == id).findFirst();

		if (themeToDelete.isPresent()) {
			themes.remove(themeToDelete.get());
			BookService.removeTheme(id);
		}
		return themes;
	}

	// Update theme
	public List<Theme> updateTheme(int id, String name, String description) {
		for (Theme theme : themes) {
			if (theme.getId() == id) {
				if (name != null)
					theme.setName(name);
				if (description != null)
					theme.setDescription(description);
			}
		}
		return themes;
	}

	public static Theme findThemeById(int id) {
		Theme t = themes.stream().filter(theme -> theme.getId() == id).findFirst().orElse(null);

		if (t != null) {
			return t;
		} else {
			System.out.println("Invalid id");
			return null;
		}
	}

}