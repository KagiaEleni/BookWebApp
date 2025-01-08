package com.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.entities.Theme;

public class ThemeService {

	private List<Theme> themes = new ArrayList<Theme>();

	// Return all Themes
	public List<Theme> getAllThemes() {
		return themes;
	}

	// Add theme
	public void addTheme(Theme theme) {
		themes.add(theme);
		this.getAllThemes();
	}

	// Delete theme
	public void deleteTheme(Theme theme) {
		Optional<Theme> themeToDelete = themes.stream().filter(themes -> themes.getId() == theme.getId()).findFirst();

		if (themeToDelete.isPresent()) {
			themes.remove(themeToDelete.get());
			BookService.removeTheme(theme.getId());
		}
		this.getAllThemes();
	}

	// Update theme
	public void updateTheme(int id, String name, String description) {
		for (Theme theme : themes) {
			if (theme.getId() == id) {
				if (name != null)
					theme.setName(name);
				if (description != null)
					theme.setDescription(description);
			}
		}
		this.getAllThemes();
	}
	
	public Theme findThemeById(int id) {
        Theme t = themes.stream()
                    .filter(theme -> theme.getId() == id)
                    .findFirst()
                    .orElse(null);
        
        if (t != null){
            return t;
        }
        else {
            System.out.println("Invalid id");
            return null;
        }
    }

}