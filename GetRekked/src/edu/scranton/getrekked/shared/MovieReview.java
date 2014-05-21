package edu.scranton.getrekked.shared;
import java.util.Date;
public class MovieReview {
	private String username;
	private String title;
	private int rating;
	private Date release_date;
	private String user_comment;
	
	public MovieReview(String username, String title, int rating, Date release_date,
			String comment){
		this.username = username;
		this.title = title;
		this.rating = rating;
		this.release_date = release_date;
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

	public Date getRelease_date() {
		return release_date;
	}

	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
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
