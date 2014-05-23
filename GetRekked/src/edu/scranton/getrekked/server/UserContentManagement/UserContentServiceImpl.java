package edu.scranton.getrekked.server.UserContentManagement;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

<<<<<<< HEAD
import edu.scranton.getrekked.client.UserContentManagement.Proxy.UserContentService;
import edu.scranton.getrekked.shared.User;

import java.util.ArrayList;
public class UserContentServiceImpl extends RemoteServiceServlet implements UserContentService {

	@Override
	public User getUser(int id) {
=======
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
>>>>>>> FETCH_HEAD
		// TODO Auto-generated method stub
		return null;
	}

	@Override
<<<<<<< HEAD
	public ArrayList<User> getAllUsers() {
=======
	public Game getGame(int barcode) {
>>>>>>> FETCH_HEAD
		// TODO Auto-generated method stub
		return null;
	}

	@Override
<<<<<<< HEAD
	public void addUser(User user) {
=======
	public void addMovie(String name, int release_year) {
>>>>>>> FETCH_HEAD
		// TODO Auto-generated method stub
		
	}

	@Override
<<<<<<< HEAD
	public void deleteUsers(ArrayList<Integer> userName) {
		// TODO Auto-generated method stub
=======
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		BookDao bookDao = new BookDao();
		bookDao.insert(book);
		bookDao.close();
>>>>>>> FETCH_HEAD
		
	}

	@Override
<<<<<<< HEAD
	public void updateUser(User updatedUser) {
		// TODO Auto-generated method stub
		
	}
//needs different proxy for user management.
=======
	public void addGame(int barcode) {
		// TODO Auto-generated method stub
		
	}
>>>>>>> FETCH_HEAD
}
