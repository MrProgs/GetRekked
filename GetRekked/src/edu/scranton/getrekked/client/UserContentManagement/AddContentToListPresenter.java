package edu.scranton.getrekked.client.UserContentManagement;

import java.util.HashMap;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.scranton.getrekked.client.AppController;
import edu.scranton.getrekked.client.ContentManagement.Proxy.ContentServiceProxy;
import edu.scranton.getrekked.shared.Book;
import edu.scranton.getrekked.shared.Game;
import edu.scranton.getrekked.shared.Movie;

public class AddContentToListPresenter {
	public static interface View {
		public void display();
	}

	private View view;
	private ContentServiceProxy contentServiceProxy = null;
	private HashMap<String, String> intent = new HashMap<String, String>();

	public AddContentToListPresenter(ContentServiceProxy proxy) {
		contentServiceProxy = proxy;
	}

	public void addBook(Book book) {
			AsyncCallback<Void> callbackAddStudent = new AsyncCallback<Void>() {
	
				public void onFailure(Throwable caught) {
					System.out.println("server error");
					intent.put("Action", "login");
					AppController.instance().go(intent);
				}
	
				public void onSuccess(Void x) {
					intent.put("Action", "home");
					AppController.instance().go(intent);
				}
			};
			System.out.println(book.toString());
			contentServiceProxy.addBook(Integer.parseInt(book.getIsbn()), callbackAddStudent);
	}
	
	public void addMovie(Movie movie){
	
			AsyncCallback<Void> callbackAddStudent = new AsyncCallback<Void>() {
				
				public void onFailure(Throwable caught) {
					System.out.println("server error");
					intent.put("Action", "login");
					AppController.instance().go(intent);
				}
	
				public void onSuccess(Void x) {
					intent.put("Action", "home");
					AppController.instance().go(intent);
				}
			};
			System.out.println(movie.toString());
			contentServiceProxy.addMovie(movie.getTitle(), movie.getRelease_year(),
					callbackAddStudent);
	}
	
	public void addGame(Game game){
			AsyncCallback<Void> callbackAddStudent = new AsyncCallback<Void>() {
				
				public void onFailure(Throwable caught) {
					System.out.println("server error");
					intent.put("Action", "login");
					AppController.instance().go(intent);
				}
	
				public void onSuccess(Void x) {
					intent.put("Action", "home");
					AppController.instance().go(intent);
				}
			};
			System.out.println(game.toString());
			contentServiceProxy.addGame(game.getBarcode(), callbackAddStudent);
	}

	public void setView(View view) {
		this.view = view;
	}

	public void cancelOperation() {
		// the user canceled the add student operation
		System.out.println("Add User operation cancelled");
		intent.put("Action", "login");
		AppController.instance().go(intent);
	}

	public void begin() {
		this.view.display();
	}
}
