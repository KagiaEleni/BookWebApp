package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.entities.Author;

public class AuthorService {
	
	private List<Author> authors = new ArrayList<Author>();
	
	public void addAuthor(Author author) {
		authors.add(author);
	}
	
	public void deleteAuthor(Author author) {
		Optional<Author> authorToDelete = authors.stream()
                .filter(authors -> authors.getId() == author.getId())
                .findFirst();

		if (authorToDelete.isPresent()) {
			authors.remove(authorToDelete.get());
		}
	} 
	
	public void updateAuthor(Author changedAuthor) {
		for(Author author: authors) {
			if(author.getId() == changedAuthor.getId()) {
				author.setFirstName(changedAuthor.getFirstName());
				author.setLastName(changedAuthor.getLastName());
				author.setDateOfBirth(changedAuthor.getDateOfBirth());
			}
		}
	}

}
