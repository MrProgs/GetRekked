package edu.scranton.getrekked.database.interfaces;


public interface ContentCreatedInterface {
	// Username and Content are passed the constructor
	
	// Content (ISBN, Barcode, "Title\tRelease Year" [example - "Star Wars Episode IV: A New Hope\t1977"])
	public String getContent();
	
	// Type (Movie, Book, or Game)
	public String getType();
	public void setType(String type);
}
