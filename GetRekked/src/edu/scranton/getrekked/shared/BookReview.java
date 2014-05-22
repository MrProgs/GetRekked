package edu.scranton.getrekked.shared;

public class BookReview {
	private String username;
	private int isbn;
	private int rating;
	private String user_comment;

	public BookReview(String username, int isbn, int rating, String comment) {
		this.username = username;
		this.isbn = isbn;
		this.rating = rating;
		this.user_comment = comment;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
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
