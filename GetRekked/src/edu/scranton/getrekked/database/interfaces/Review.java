package edu.scranton.getrekked.database.interfaces;

public interface Review {
	// Rating
	public int getRating();
	public void setRating(int rating);
	
	// User Comment
	public String getUserComment();
	public void setUserComment(String userComment);
}
