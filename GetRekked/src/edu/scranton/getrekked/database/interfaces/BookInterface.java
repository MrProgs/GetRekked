package edu.scranton.getrekked.database.interfaces;

import java.util.ArrayList;

public interface BookInterface {
	// ISBN will be passed through the Book constructor
	
	// Getters and Setters
	
	// ISBN
	public String getIsbn();
	
	// Title
	public String getTitle();
	public void setTitle(String title);
	
	// Author
	public String getAuthor();
	public void setAuthor(String author);
	
	// Publisher
	public String getPublisher();
	public void setPublisher(String publisher);
	
	// Image - a link
	public String getImage();
	public void setImage(String imageUrl);
	
	// Language
	// Assumption - only one language per book
	public String getLanguage();
	public void setLanguage(String language);
	
	// Number of Pages
	public int getNumberOfPages();
	public void setNumberOfPages(int numberOfPages);
	
	// Genres
	public ArrayList<String> getGenres();
	public void addGenre(String genre);
	
	// Awards
	public ArrayList<String> getAwards();
	public void addAward(String award);
}
