package edu.scranton.getrekked.client.ContentManagement.Proxy;

import java.util.Date;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.scranton.getrekked.shared.Book;
import edu.scranton.getrekked.shared.Movie;
import edu.scranton.getrekked.shared.Game;

@RemoteServiceRelativePath("contentService")
public interface ContentService extends RemoteService  {
	public Book getBook(int isbn);
	public Movie getMovie(String title, Date release_date);
	public Game getGame(int barcode);
}
