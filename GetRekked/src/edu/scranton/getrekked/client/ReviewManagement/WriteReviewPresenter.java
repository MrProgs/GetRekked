package edu.scranton.getrekked.client.ReviewManagement;

import java.util.HashMap;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.scranton.getrekked.client.AppController;
import edu.scranton.getrekked.client.ReviewManagement.Proxy.ReviewServiceProxy;
import edu.scranton.getrekked.client.ContentManagement.Proxy.ContentServiceProxy;
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
	private ContentServiceProxy contentServiceProxy;
	private Book book;
	private Movie movie;
	private Game game;
	private User user;
	
	public WriteReviewPresenter(ReviewServiceProxy proxy){
		this.reviewServiceProxy = proxy;
	}
	
	public void cancelOperation() {
		// the user canceled the write review operation
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
			getContentInfo();
		} else {
			this.intent.put("Action", "login");
			AppController.instance().go(intent);
		}
	}
	
	public void writeReview(String review, int ranking){
		if(intent.get("Category").equals("Book")){
			AsyncCallback<BookReview> callbackWriteBookReview = new AsyncCallback<BookReview>() {

				public void onFailure(Throwable caught) {
					System.out.println("server error");
					intent.put("Action","home");
					AppController.instance().go(intent);
				}
				
				public void onSuccess(BookReview x) {
					intent.put("Action","home");
					AppController.instance().go(intent);
					
				}
			};
			System.out.println(book.getTitle());
			reviewServiceProxy.writeBookReview(user.getUserName(),book.getIsbn(),review,ranking,callbackWriteBookReview);
		}
		else if (intent.get("Category").equals("Movie")){
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
			System.out.println(movie.getTitle()+" ("+movie.getRelease_date()+")");
			reviewServiceProxy.writeMovieReview(user.getUserName(),movie.getTitle(),movie.getRelease_date(),review,ranking,
					callbackWriteMovieReview);
		}
		else{ //(intent.get("Category").equals("Game"))
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
			System.out.println(game.getTitle()+" ("+game.getBarcode()+")");
			reviewServiceProxy.writeGameReview(user.getUserName(), game.getBarcode(), review, ranking, callbackWriteGameReview);
		}
		this.intent.put("Action", "home");
		AppController.instance().go(intent);
	}
	
	public void getContentInfo(){
		if(intent.get("Category").equals("Book")){
			AsyncCallback<Book> callbackGetBook = new AsyncCallback<Book>() {

				public void onFailure(Throwable caught) {
					System.out.println("server error");
					intent.put("Action","home");
					AppController.instance().go(intent);
				}
				
				public void onSuccess(Book x) {
					((WriteReviewView) view).setBookData(x);
					view.display();
					
				}
			};
			System.out.println(book.getTitle());
			contentServiceProxy.getBook(book.getIsbn(), callbackGetBook);
		}
		else if(intent.get("Category").equals("Movie")){
			AsyncCallback<Movie> callbackGetMovie = new AsyncCallback<Movie>() {

				public void onFailure(Throwable caught) {
					System.out.println("server error");
					intent.put("Action","home");
					AppController.instance().go(intent);
				}
				
				public void onSuccess(Movie x) {
					((WriteReviewView) view).setMovieData(x);
					view.display();
					
				}
			};
			System.out.println(movie.getTitle()+" ("+movie.getRelease_date()+")");
			contentServiceProxy.getMovie(movie.getTitle(), movie.getRelease_date(), callbackGetMovie);
		}
		else{ //intent.get("Category").equals("Game")
			AsyncCallback<Game> callbackGetGame = new AsyncCallback<Game>() {

				public void onFailure(Throwable caught) {
					System.out.println("server error");
					intent.put("Action","home");
					AppController.instance().go(intent);
				}
				
				public void onSuccess(Game x) {
					((WriteReviewView) view).setGameData(x);
					view.display();
					
				}
			};
			System.out.println(game.getTitle()+" ("+game.getBarcode()+")");
			contentServiceProxy.getGame(game.getBarcode(), callbackGetGame);
		}
	}
	
}
