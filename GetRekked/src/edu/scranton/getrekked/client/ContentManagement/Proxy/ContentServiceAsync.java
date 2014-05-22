package edu.scranton.getrekked.client.ContentManagement.Proxy;

import java.util.Date;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.scranton.getrekked.shared.Book;
import edu.scranton.getrekked.shared.Game;
import edu.scranton.getrekked.shared.Movie;

public interface ContentServiceAsync {

	void getBook(int isbn, AsyncCallback<Book> callbackGetBook);

	void getMovie(String title, String release_date,
			AsyncCallback<Movie> callbackGetMovie);

	void getGame(int barcode, AsyncCallback<Game> callbackGetGame);
}
