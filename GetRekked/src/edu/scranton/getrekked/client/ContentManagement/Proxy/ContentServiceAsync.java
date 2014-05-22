package edu.scranton.getrekked.client.ContentManagement.Proxy;


import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.scranton.getrekked.shared.Book;
import edu.scranton.getrekked.shared.Game;
import edu.scranton.getrekked.shared.Movie;

public interface ContentServiceAsync {

	void getBook(int isbn, AsyncCallback<Book> callbackGetBook);

	void getMovie(String title, int release_year,
			AsyncCallback<Movie> callbackGetMovie);

	void getGame(int barcode, AsyncCallback<Game> callbackGetGame);
}
