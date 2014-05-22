package edu.scranton.getrekked.shared;


public class MovieReview {
	private String username;
	private String title;
	private int rating;
	private int release_year;
	private String user_comment;

	public MovieReview(String username, String title, int rating,
			int release_year, String comment) {
		this.username = username;
		this.title = title;
		this.rating = rating;
		this.release_year = release_year;
		this.user_comment = comment;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getRelease_year() {
		return release_year;
	}

	public void setRelease_year(int release_year) {
		this.release_year = release_year;
	}

	public String getUser_comment() {
		return user_comment;
	}

	public void setUser_comment(String user_comment) {
		this.user_comment = user_comment;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}
