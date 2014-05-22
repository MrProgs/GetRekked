package edu.scranton.getrekked.client.ContentManagement.Proxy;


import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.scranton.getrekked.shared.Book;
import edu.scranton.getrekked.shared.Game;
import edu.scranton.getrekked.shared.Movie;

@RemoteServiceRelativePath("contentService")
public interface ContentService extends RemoteService {
	public Book getBook(int isbn);

	public Movie getMovie(String title, int release_year);

	public Game getGame(int barcode);
	
	public void addMovie(String name, int release_year);
	
	public void addBook(int isbn);
	
	public void addGame(int barcode);
}
