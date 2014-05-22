package edu.scranton.getrekked.client.ContentManagement.Proxy;

import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.scranton.getrekked.client.ContentManagement.Proxy.ContentService;
import edu.scranton.getrekked.client.ContentManagement.Proxy.ContentServiceAsync;
import edu.scranton.getrekked.shared.Movie;
import edu.scranton.getrekked.shared.Book;
import edu.scranton.getrekked.shared.Game;

public class ContentServiceProxy {
	public void getBook(int isbn, AsyncCallback<Book> callbackGetBook){
		ContentServiceAsync contentService = GWT.create(ContentService.class);
		contentService.getBook(isbn, callbackGetBook);
	}
	
	public void getMovie(String title, Date release_date, AsyncCallback<Movie> callbackGetMovie){
		ContentServiceAsync contentService = GWT.create(ContentService.class);
		contentService.getMovie(title, release_date, callbackGetMovie);
	}
	
	public void getGame(int barcode, AsyncCallback<Game> callbackGetGame){
		ContentServiceAsync contentService = GWT.create(ContentService.class);
		contentService.getGame(barcode, callbackGetGame);
	}
}
