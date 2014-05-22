package edu.scranton.getrekked.database.interfaces;

import java.util.ArrayList;

public interface GameInterface {
	// Barcode will be passed into constructor
	
	// Getters and Setters
	
	// Barcode
	public int getBarcode();

	// Title
	public String getTitle();
	public void setTitle(String title);
	
	// Publisher
	// Assuming a game has only one publisher
	public String getPublisher();
	public void setPublisher(String publisher);
	
	// Image - a link
	public String getImage();
	public void setImage(String imageUrl);
	
	// ESRB
	public String getEsrb();
	public void setEsrb(String esrb);
	
	// Release date
	public String getReleaseDate();
	public void setReleaseDate(String releaseDate);
	
	// Genres
	public ArrayList<String> getGenres();
	public void addGenre(String genre);
	
	// Awards
	public ArrayList<String> getAwards();
	public void addAward(String award);
	
	// Developers
	public ArrayList<String> getDevelopers();
	public void addDeveloper(String developer);
	
	// Systems
	public ArrayList<String> getSystems();
	public void addSystem(String system);
}
