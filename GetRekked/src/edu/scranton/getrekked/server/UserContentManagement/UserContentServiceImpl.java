package edu.scranton.getrekked.server.UserContentManagement;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.scranton.getrekked.client.ContentManagement.Proxy.ContentService;
import edu.scranton.getrekked.shared.Book;
import edu.scranton.getrekked.shared.BookDao;
import edu.scranton.getrekked.shared.Game;
import edu.scranton.getrekked.shared.Movie;
public class UserContentServiceImpl extends RemoteServiceServlet implements ContentService {

	@Override
	public Book getBook(String isbn) {
		// TODO Auto-generated method stub
		BookDao bookDao = new BookDao();
		bookDao.getBook(isbn);
		bookDao.close();
		return null;
	}

	@Override
	public Movie getMovie(String title, int release_year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Game getGame(int barcode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addMovie(String name, int release_year) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		BookDao bookDao = new BookDao();
		bookDao.insert(book);
		bookDao.close();
		
	}

	@Override
	public void addGame(int barcode) {
		// TODO Auto-generated method stub
		
	}
}
