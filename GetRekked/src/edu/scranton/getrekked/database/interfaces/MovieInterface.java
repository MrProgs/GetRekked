package edu.scranton.getrekked.database.interfaces;

import java.util.ArrayList;

import edu.scranton.getrekked.shared.CastMember;
public interface MovieInterface {
	// Title and Release Year will be passed through the Constructor
	
	// Getters and Setters
	
	// Title
	public String getTitle();
	
	// Release Year
	public int getReleaseYear();
	
	// Image - a link
	public String getImage();
	public void setImage(String imageUrl);
	
	// MPAA Rating
	public String getMpaaRating();
	public void setMpaaRating(String mpaaRating);
	
	// Runtime - will be in the form of HH:MM:SS
	public String getRuntime();
	public void setRuntime(String runtime);
	
	// Directors
	public ArrayList<String> getDirectors();
	public void addDirector(String director);
	
	// Producers
	public ArrayList<String> getProducers();
	public void addProducer(String producer);
	
	// Cast
	public ArrayList<CastMember> getCast();
	public void addCastMember(CastMember c);
	
	// Awards
	public ArrayList<String> getAwards();
	public void addAward(String award);

	public String getLanguage();

	public void setLanguage(String language);
}
