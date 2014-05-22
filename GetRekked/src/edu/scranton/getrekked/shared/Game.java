package edu.scranton.getrekked.shared;


public class Game {
	private int barcode;
	private String publisher;
	private String esrb;
	private int release_date;
	private String title;

	public Game(int barcode, String publisher, String esrb, int release_date,
			String title) {
		this.barcode = barcode;
		this.publisher = publisher;
		this.esrb = esrb;
		this.release_date = release_date;
		this.title = title;
	}

	public int getBarcode() {
		return barcode;
	}

	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getEsrb() {
		return esrb;
	}

	public void setEsrb(String esrb) {
		this.esrb = esrb;
	}

	public int getRelease_date() {
		return release_date;
	}

	public void setRelease_date(int release_date) {
		this.release_date = release_date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
