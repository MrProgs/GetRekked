package edu.scranton.getrekked.shared;

public class GameReview {
	private String username;
	private int barcode;
	private int rating;
	private String user_comment;
	
	public GameReview(String username, int barcode, int rating, String comment){
		this.username = username;
		this.barcode = barcode;
		this.rating = rating;
		this.user_comment = comment;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getBarcode() {
		return barcode;
	}

	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getUser_comment() {
		return user_comment;
	}

	public void setUser_comment(String user_comment) {
		this.user_comment = user_comment;
	}
	
	
}
