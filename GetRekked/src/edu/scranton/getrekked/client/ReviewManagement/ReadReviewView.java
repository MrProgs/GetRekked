package edu.scranton.getrekked.client.ReviewManagement;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

import edu.scranton.getrekked.shared.Book;
import edu.scranton.getrekked.shared.BookReview;
import edu.scranton.getrekked.shared.Game;
import edu.scranton.getrekked.shared.GameReview;
import edu.scranton.getrekked.shared.Movie;
import edu.scranton.getrekked.shared.MovieReview;
import edu.scranton.getrekked.shared.User;

public class ReadReviewView {
	private DecoratorPanel mainPanel = null;
	private ReadReviewPresenter dispatcher;
	private FlexTable reviewTable = new FlexTable();
	private TextBox reviewBox;
	private TextBox rankingBox;
	private BookReview bookReview;
	private ArrayList<BookReview> bookReviews;
	private Book mBook;
	private MovieReview movieReview;
	private ArrayList<MovieReview> movieReviews;
	private Movie mMovie;
	private GameReview gameReview;
	private ArrayList<GameReview> gameReviews;
	private Game mGame;
	private User reviewer;

	public ReadReviewView(ReadReviewPresenter presenter) {
		this.dispatcher = presenter;
		mainPanel = new DecoratorPanel();
		HorizontalPanel menuPanel = new HorizontalPanel();
		Button cancelButton = new Button("Cancel");
		menuPanel.add(cancelButton);
		cancelButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dispatcher.cancelOperation();
			}
		});

	}

	public void display() {
		resetInputBoxes();
		RootPanel.get().clear();
		RootPanel.get().add(mainPanel);
	}

	private void resetInputBoxes() {

	}

	public void setBookData(Book book) {
		mBook = book;
	}

	public void setBookListData(ArrayList<BookReview> reviews) {
		bookReviews = reviews;
	}

	public void setBookReviewData(BookReview review) {
		bookReview = review;
	}

	public void setMovieData(Movie movie) {
		mMovie = movie;
	}

	public void setMovieListData(ArrayList<MovieReview> reviews) {
		movieReviews = reviews;
	}

	public void setMovieReviewData(MovieReview review) {
		movieReview = review;
	}

	public void setGameData(Game game) {
		mGame = game;
	}

	public void setGameListData(ArrayList<GameReview> reviews) {
		gameReviews = reviews;
	}

	public void setGameReviewData(GameReview review) {
		gameReview = review;
	}

	public void setUserData(User user) {
		reviewer = user;
	}
}
