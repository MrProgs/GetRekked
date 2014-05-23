package edu.scranton.getrekked.shared;

import java.util.ArrayList;
public class Movie {
	private String title;
	private int release_year;
	private int MPAA_rating;
	private String language;
	private int runtime;
	private String imageLink;
	private ArrayList<String> genres;
	private ArrayList<String> awards;

	public Movie(String title, int release_year) {
		super();
		this.title = title;
		this.release_year = release_year;
		//this.MPAA_rating = MPAA_rating;
		//this.language = language;
		//this.runtime = runtime;
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

	public void setRelease_date(int release_year) {
		this.release_year = release_year;
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

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public ArrayList<String> getGenres() {
		return genres;
	}

	public void setGenres(ArrayList<String> genres) {
		this.genres = genres;
	}

	public ArrayList<String> getAwards() {
		return awards;
	}

	public void setAwards(ArrayList<String> awards) {
		this.awards = awards;
	}
}
