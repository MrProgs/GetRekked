package edu.scranton.getrekked.client.ReviewManagement.Proxy;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.scranton.getrekked.shared.BookReview;
import edu.scranton.getrekked.shared.GameReview;
import edu.scranton.getrekked.shared.MovieReview;

public interface ReviewServiceAsync {

	void getMovieReview(String user, String title, int release_year,
			AsyncCallback<MovieReview> callbackGetMovieReview);

	void getAllMovieReviews(String title, int release_year,
			AsyncCallback<ArrayList<MovieReview>> callbackGetMovieReviews);

	void writeMovieReview(String user, String title, int release_year,
			String review, int rank,
			AsyncCallback<MovieReview> callbackWriteMovieReview);

	void getBookReview(String user, int isbn,
			AsyncCallback<BookReview> callbackGetBookReview);

	void getAllBookReviews(int isbn,
			AsyncCallback<ArrayList<BookReview>> callbackGetBookReviews);

	void writeBookReview(String user, int isbn, String review, int rank,
			AsyncCallback<BookReview> callbackWriteBookReview);

	void getGameReview(String user, int barcode,
			AsyncCallback<GameReview> callbackGetGameReview);

	void getAllGameReviews(int barcode,
			AsyncCallback<ArrayList<GameReview>> callbackGetGameReviews);

	void writeGameReview(String user, int barcode, String review, int rank,
			AsyncCallback<GameReview> callbackWriteGameReview);

}
