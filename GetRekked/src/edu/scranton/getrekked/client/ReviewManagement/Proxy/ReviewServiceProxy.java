package edu.scranton.getrekked.client.ReviewManagement.Proxy;

import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.scranton.getrekked.shared.BookReview;
import edu.scranton.getrekked.shared.GameReview;
//import edu.scranton.getrekked.shared.User;
import edu.scranton.getrekked.shared.MovieReview;

public class ReviewServiceProxy {
	public void getBookReview(String user, int isbn,
			AsyncCallback<BookReview> callbackGetBookReview) {
		ReviewServiceAsync reviewService = GWT.create(ReviewService.class);
		reviewService.getBookReview(user, isbn, callbackGetBookReview);
	}

	public void getAllBookReviews(int isbn,
			AsyncCallback<ArrayList<BookReview>> callbackGetBookReviews) {
		ReviewServiceAsync reviewService = GWT.create(ReviewService.class);
		reviewService.getAllBookReviews(isbn, callbackGetBookReviews);
	}

	public void writeBookReview(String user, int isbn, String review, int rank,
			AsyncCallback<BookReview> callbackWriteBookReview) {
		ReviewServiceAsync reviewService = GWT.create(ReviewService.class);
		reviewService.writeBookReview(user, isbn, review, rank,
				callbackWriteBookReview);
	}

	public void getMovieReview(String user, String title, String release_date,
			AsyncCallback<MovieReview> callbackGetMovieReview) {
		ReviewServiceAsync reviewService = GWT.create(ReviewService.class);
		reviewService.getMovieReview(user, title, release_date,
				callbackGetMovieReview);
	}

	public void getAllMovieReviews(String title, String release_date,
			AsyncCallback<ArrayList<MovieReview>> callbackGetMovieReviews) {
		ReviewServiceAsync reviewService = GWT.create(ReviewService.class);
		reviewService.getAllMovieReviews(title, release_date,
				callbackGetMovieReviews);
	}

	public void writeMovieReview(String user, String title, String release_date,
			String review, int rank,
			AsyncCallback<MovieReview> callbackWriteMovieReview) {
		ReviewServiceAsync reviewService = GWT.create(ReviewService.class);
		reviewService.writeMovieReview(user, title, release_date, review, rank,
				callbackWriteMovieReview);
	}

	public void getGameReview(String user, int barcode,
			AsyncCallback<GameReview> callbackGetGameReview) {
		ReviewServiceAsync reviewService = GWT.create(ReviewService.class);
		reviewService.getGameReview(user, barcode, callbackGetGameReview);
	}

	public void getAllGameReviews(int barcode,
			AsyncCallback<ArrayList<GameReview>> callbackGetGameReviews) {
		ReviewServiceAsync reviewService = GWT.create(ReviewService.class);
		reviewService.getAllGameReviews(barcode, callbackGetGameReviews);
	}

	public void writeGameReview(String user, int barcode, String review,
			int rank, AsyncCallback<GameReview> callbackWriteGameReview) {
		ReviewServiceAsync reviewService = GWT.create(ReviewService.class);
		reviewService.writeGameReview(user, barcode, review, rank,
				callbackWriteGameReview);
	}
}
