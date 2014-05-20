package edu.scranton.getrekked.shared;

public class Book {
	private int isbn;
	private String title;
	private String author;
	private String publisher;
	private String language;
	private String genre;
	private int numOfPages;
	private char copyRight;

	public Book(int isbn, String title, String author, String publisher,
			String language, String genre, int numOfPages, char copyRight) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.language = language;
		this.genre = genre;
		this.numOfPages = numOfPages;
		this.copyRight = copyRight;
	}
	public int getNumOfPages() {
		return numOfPages;
	}
	public void setNumOfPages(int numOfPages) {
		this.numOfPages = numOfPages;
	}
	public char getCopyRight() {
		return copyRight;
	}
	public void setCopyRight(char copyRight) {
		this.copyRight = copyRight;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
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
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
}
