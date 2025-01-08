package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.entities.Theme;

public class ThemeService {

	private List<Theme> themes = new ArrayList<Theme>();
	
	public void addTheme(Theme theme) {
		themes.add(theme);
	}
	
	public void deleteTheme(Theme theme) {
		Optional<Theme> themeToDelete = themes.stream()
                .filter(themes -> themes.getId() == theme.getId())
                .findFirst();

		if (themeToDelete.isPresent()) {
			themes.remove(themeToDelete.get());
		}
	}
	
	public void updateTheme(Theme changedTheme) {
		for(Theme theme:themes) {
			if(theme.getId() == changedTheme.getId()) {
				theme.setName(changedTheme.getName());
				theme.setDescription(changedTheme.getDescription());
			}
		}
	}
		
}