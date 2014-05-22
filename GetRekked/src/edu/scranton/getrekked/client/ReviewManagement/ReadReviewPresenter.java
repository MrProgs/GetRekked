package edu.scranton.getrekked.client.ReviewManagement;

import java.text.ParseException;
import com.google.gwt.i18n.client.DateTimeFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Pattern;


import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.scranton.getrekked.client.AppController;
import edu.scranton.getrekked.client.ContentManagement.Proxy.ContentServiceProxy;
import edu.scranton.getrekked.client.ReviewManagement.Proxy.ReviewServiceProxy;
import edu.scranton.getrekked.shared.Book;
import edu.scranton.getrekked.shared.BookReview;
import edu.scranton.getrekked.shared.Game;
import edu.scranton.getrekked.shared.GameReview;
import edu.scranton.getrekked.shared.Movie;
import edu.scranton.getrekked.shared.MovieReview;
import edu.scranton.getrekked.shared.User;

public class ReadReviewPresenter {
	public static interface View {
		public void display();
	}

	private View view;
	private HashMap<String, String> intent;
	private ReviewServiceProxy reviewServiceProxy;
	private ContentServiceProxy contentServiceProxy;
	private Book book;
	private Movie movie;
	private Game game;
	private User reviewer;

	public ReadReviewPresenter(ReviewServiceProxy proxy) {
		this.reviewServiceProxy = proxy;
	}

	public void cancelOperation() {
		// the user canceled the read review operation
		System.out.println("Read Review operation cancelled");
		this.intent.put("Action", "home");
		AppController.instance().go(intent);
	}

	public void setView(View view) {
		this.view = view;
	}

	public void setIntent(HashMap<String, String> intent) {
		this.intent = intent;
	}

	public void begin() {
		// check if the user has successfully logged in.
		if (AppController.instance().isUserLoggedIn()) {
			readReview(reviewer);
		} else {
			this.intent.put("Action", "login");
			AppController.instance().go(intent);
		}
	}

	// read a review written by the given user.
	public void readReview(User reviewer) {
		if (intent.get("Category").equals("Book")) {
			AsyncCallback<BookReview> callbackReadBookReview = new AsyncCallback<BookReview>() {

				public void onFailure(Throwable caught) {
					System.out.println("server error");
					intent.put("Action", "home");
					AppController.instance().go(intent);
				}

				public void onSuccess(BookReview x) {
					((ReadReviewView) view).setBookReviewData(x);
					view.display();

				}
			};
			System.out.println(book.getTitle());
			reviewServiceProxy.getBookReview(reviewer.getUserName(),
					book.getIsbn(), callbackReadBookReview);
		} else if (intent.get("Category").equals("Movie")) {
			AsyncCallback<MovieReview> callbackReadMovieReview = new AsyncCallback<MovieReview>() {

				public void onFailure(Throwable caught) {
					System.out.println("server error");
					intent.put("Action", "home");
					AppController.instance().go(intent);
				}

				public void onSuccess(MovieReview x) {
					((ReadReviewView) view).setMovieReviewData(x);
					view.display();
				}
			};
			System.out.println(movie.getTitle() + " ("
					+ movie.getRelease_date() + ")");
			reviewServiceProxy.getMovieReview(reviewer.getUserName(),
					movie.getTitle(), movie.getRelease_date(),
					callbackReadMovieReview);
		} else { // (intent.get("Category").equals("Game"))
			AsyncCallback<GameReview> callbackReadGameReview = new AsyncCallback<GameReview>() {

				public void onFailure(Throwable caught) {
					System.out.println("server error");
					intent.put("Action", "home");
					AppController.instance().go(intent);
				}

				public void onSuccess(GameReview x) {
					((ReadReviewView) view).setGameReviewData(x);
					view.display();
				}
			};
			int barcode = Integer.parseInt(this.intent.get("Barcode"));
			reviewServiceProxy.getGameReview(reviewer.getUserName(), barcode,
					callbackReadGameReview);
		}
		this.intent.put("Action", "home");
		AppController.instance().go(intent);
	}

	// read all the reviews about a certain book, movie, or game
	public void readAllReviews(String[] identifiers) {
		if (intent.get("Category").equals("Book")) {
			AsyncCallback<ArrayList<BookReview>> callbackReadBookReview = new AsyncCallback<ArrayList<BookReview>>() {

				public void onFailure(Throwable caught) {
					System.out.println("server error");
					intent.put("Action", "home");
					AppController.instance().go(intent);
				}

				public void onSuccess(ArrayList<BookReview> x) {
					((ReadReviewView) view).setBookListData(x);
					view.display();

				}
			};
			System.out.println(book.getTitle());
			reviewServiceProxy.getAllBookReviews(book.getIsbn(),
					callbackReadBookReview);
		} else if (intent.get("Category").equals("Movie")) {
			AsyncCallback<ArrayList<MovieReview>> callbackReadMovieReview = new AsyncCallback<ArrayList<MovieReview>>() {

				public void onFailure(Throwable caught) {
					System.out.println("server error");
					intent.put("Action", "home");
					AppController.instance().go(intent);
				}

				public void onSuccess(ArrayList<MovieReview> x) {
					((ReadReviewView) view).setMovieListData(x);
					view.display();
				}
			};
			System.out.println(movie.getTitle() + " ("
					+ movie.getRelease_date() + ")");
			reviewServiceProxy.getAllMovieReviews(movie.getTitle(),
					movie.getRelease_date(), callbackReadMovieReview);
		} else { // (intent.get("Category").equals("Game"))
			AsyncCallback<ArrayList<GameReview>> callbackReadGameReview = new AsyncCallback<ArrayList<GameReview>>() {

				public void onFailure(Throwable caught) {
					System.out.println("server error");
					intent.put("Action", "home");
					AppController.instance().go(intent);
				}

				public void onSuccess(ArrayList<GameReview> x) {
					((ReadReviewView) view).setGameListData(x);
					view.display();
				}
			};
			int barcode = Integer.parseInt(this.intent.get("Barcode"));
			reviewServiceProxy.getAllGameReviews(barcode,
					callbackReadGameReview);
		}
		this.intent.put("Action", "home");
		AppController.instance().go(intent);
	}

	public void getContentInfo() {
		if (intent.get("Category").equals("Book")) {
			AsyncCallback<Book> callbackGetBook = new AsyncCallback<Book>() {

				public void onFailure(Throwable caught) {
					System.out.println("server error");
					intent.put("Action", "home");
					AppController.instance().go(intent);
				}

				public void onSuccess(Book x) {
					((ReadReviewView) view).setBookData(x);

				}
			};
			int isbn = Integer.parseInt(this.intent.get("ISBN"));
			contentServiceProxy.getBook(isbn, callbackGetBook);
		} else if (intent.get("Category").equals("Movie")) {
			AsyncCallback<Movie> callbackGetMovie = new AsyncCallback<Movie>() {

				public void onFailure(Throwable caught) {
					System.out.println("server error");
					intent.put("Action", "home");
					AppController.instance().go(intent);
				}

				public void onSuccess(Movie x) {
					((WriteReviewView) view).setMovieData(x);
					view.display();

				}
			};
			String title = this.intent.get("Title");
			Date date = new Date("MM/dd/yy");
			String release_date = DateTimeFormat.getShortDateFormat().format(date);

			contentServiceProxy.getMovie(title, release_date, callbackGetMovie);
		} else { // intent.get("Category").equals("Game")
			AsyncCallback<Game> callbackGetGame = new AsyncCallback<Game>() {

				public void onFailure(Throwable caught) {
					System.out.println("server error");
					intent.put("Action", "home");
					AppController.instance().go(intent);
				}

				public void onSuccess(Game x) {
					((WriteReviewView) view).setGameData(x);
					view.display();

				}
			};
			int barcode = Integer.parseInt(this.intent.get("Barcode"));
			contentServiceProxy.getGame(barcode, callbackGetGame);
		}
	}

	/*
	 * public void getUserInfo(){ AsyncCallback<User> callbackGetUser = new
	 * AsyncCallback<User>() {
	 * 
	 * public void onFailure(Throwable caught) {
	 * System.out.println("server error"); intent.put("Action","home");
	 * AppController.instance().go(intent); }
	 * 
	 * public void onSuccess(User x) { ((ReadReviewView) view).setUserData(x);
	 * view.display(); } }; String username = this.intent.get("Username");
	 * //userServiceProxy.getStudent(username, callbackGetStudent); }
	 */
}
