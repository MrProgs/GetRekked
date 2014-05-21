package edu.scranton.getrekked.client.ReviewManagement;

import java.util.HashMap;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.scranton.getrekked.client.AppController;
import edu.scranton.getrekked.client.ReviewManagement.Proxy.ReviewServiceProxy;
import edu.scranton.getrekked.shared.Book;
import edu.scranton.getrekked.shared.BookReview;
import edu.scranton.getrekked.shared.GameReview;
import edu.scranton.getrekked.shared.Movie;
import edu.scranton.getrekked.shared.Game;
import edu.scranton.getrekked.shared.MovieReview;
import edu.scranton.getrekked.shared.User;

public class WriteReviewPresenter {
	public static interface View{
		public void display();
	}
	
	private View view;
	private HashMap<String,String> intent;
	private ReviewServiceProxy reviewServiceProxy;
	private Book book;
	private Movie movie;
	private Game game;
	private User user;
	
	public WriteReviewPresenter(ReviewServiceProxy proxy){
		this.reviewServiceProxy = proxy;
	}
	
	public void cancelOperation() {
		// the user canceled the edit student operation
		System.out.println("Write Review operation cancelled");
		this.intent.put("Action", "home");
		AppController.instance().go(intent);
	}
	
	public void setView(View view) {
		this.view = view;
	}
	
	public void setIntent(HashMap<String,String> intent){
		this.intent = intent;
	}
	
	public void begin() {
		// check if the user has successfully logged in.
		if (AppController.instance().isUserLoggedIn()) {
			//STUB
		} else {
			this.intent.put("Action", "login");
			AppController.instance().go(intent);
		}
	}
	
	public void writeReview(String review, int ranking){
		AsyncCallback<BookReview> callbackWriteBookReview = new AsyncCallback<BookReview>() {

			public void onFailure(Throwable caught) {
				System.out.println("server error");
				intent.put("Action","home");
				AppController.instance().go(intent);
			}
			
			public void onSuccess(BookReview x) {
				((WriteReviewView) view).setBookData(x);
				view.display();
				
			}
		};
		AsyncCallback<MovieReview> callbackWriteMovieReview = new AsyncCallback<MovieReview>() {

			public void onFailure(Throwable caught) {
				System.out.println("server error");
				intent.put("Action","home");
				AppController.instance().go(intent);
			}
			
			public void onSuccess(MovieReview x) {
				intent.put("Action","home");
				AppController.instance().go(intent);
			}
		};
		AsyncCallback<GameReview> callbackWriteGameReview = new AsyncCallback<GameReview>() {

			public void onFailure(Throwable caught) {
				System.out.println("server error");
				intent.put("Action","home");
				AppController.instance().go(intent);
			}
			
			public void onSuccess(GameReview x) {
				intent.put("Action","home");
				AppController.instance().go(intent);
			}
		};
		if(intent.get("Category").equals("Book")){
			System.out.println(book.getTitle());
			reviewServiceProxy.writeBookReview(user.getUserName(),book.getIsbn(),review,ranking,callbackWriteBookReview);
		}
		else if (intent.get("Category").equals("Movie")){
			System.out.println(movie.getTitle()+" ("+movie.getRelease_date()+")");
			reviewServiceProxy.writeMovieReview(user.getUserName(),movie.getTitle(),movie.getRelease_date(),review,ranking,
					callbackWriteMovieReview);
		}
		else{ //(intent.get("Category").equals("Game"))
			System.out.println(game.getTitle()+" ("+game.getBarcode()+")");
			reviewServiceProxy.writeGameReview(user.getUserName(), game.getBarcode(), review, ranking, callbackWriteGameReview);
		}
		this.intent.put("Action", "home");
		AppController.instance().go(intent);
	}
	
}
