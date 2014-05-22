package edu.scranton.getrekked.shared;

import java.util.Date;

public class Movie {
	private String title;
	private Date release_date;
	private int MPAA_rating;
	private String language;
	private int runtime;

	public Movie(String title, Date release_date, int mPAA_rating,
			String language, int runtime) {
		super();
		this.title = title;
		this.release_date = release_date;
		this.MPAA_rating = mPAA_rating;
		this.language = language;
		this.runtime = runtime;
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
	public int getMPAA_rating() {
		return MPAA_rating;
	}
	public void setMPAA_rating(int mPAA_rating) {
		MPAA_rating = mPAA_rating;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getRuntime() {
		return runtime;
	}
	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}
}
