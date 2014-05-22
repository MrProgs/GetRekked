package edu.scranton.getrekked.shared;

import java.util.ArrayList;

public class Book {
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private String language;
	private String imageLink;
	private ArrayList<String> genres;
	private ArrayList<String> awards;
	private int numOfPages;
	private String copyRight;

	public Book(String isbn) {
		super();
		this.isbn = isbn;
	}

	public ArrayList<String> getGenres() {
		return genres;
	}

	public void setGenres(ArrayList<String> genres) {
		this.genres = genres;
	}
	
	public void addGenre(String genre){
		this.genres.add(genre);
	}

	public ArrayList<String> getAwards() {
		return awards;
	}

	public void setAwards(ArrayList<String> awards) {
		this.awards = awards;
	}
	
	public void addAward(String award){
		this.awards.add(award);
	}

	public int getNumOfPages() {
		return numOfPages;
	}

	public void setNumOfPages(int numOfPages) {
		this.numOfPages = numOfPages;
	}

	public String getCopyRight() {
		return copyRight;
	}

	public void setCopyRight(String copyRight) {
		this.copyRight = copyRight;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}


}
