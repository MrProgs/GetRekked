package edu.scranton.getrekked.client.ReviewManagement.Proxy;

import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.scranton.getrekked.shared.BookReview;
import edu.scranton.getrekked.shared.GameReview;
import edu.scranton.getrekked.shared.MovieReview;

@RemoteServiceRelativePath("reviewService")
public interface ReviewService extends RemoteService {
	public MovieReview getMovieReview(String user, String title,
			Date release_date);

	public ArrayList<MovieReview> getAllMovieReviews(String title,
			Date release_date);

	public MovieReview writeMovieReview(String user, String title,
			Date release_date, String review, int rank);

	public BookReview getBookReview(String user, int isbn);

	public ArrayList<BookReview> getAllBookReviews(int isbn);

	public BookReview writeBookReview(String user, int isbn, String review,
			int rank);

	public GameReview getGameReview(String user, int barcode);

	public ArrayList<GameReview> getAllGameReviews(int barcode);

	public GameReview writeGameReview(String user, int barcode, String review,
			int rank);
}
