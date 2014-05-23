package edu.scranton.getrekked.client.ReviewManagement.Proxy;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.scranton.getrekked.shared.BookReview;
import edu.scranton.getrekked.shared.GameReview;
import edu.scranton.getrekked.shared.MovieReview;

@RemoteServiceRelativePath("reviewService")
public interface ReviewService extends RemoteService {
	public MovieReview getMovieReview(String user, String title,
			int release_year);

	public ArrayList<MovieReview> getAllMovieReviews(String title,
			int release_year);

	public MovieReview writeMovieReview(String user, String title,
			int release_year, String review, int rank);

	public BookReview getBookReview(String user, int isbn);

	public ArrayList<BookReview> getAllBookReviews(int isbn);

	public BookReview writeBookReview(String user, String isbn, String review,
			String rank);

	public GameReview getGameReview(String user, int barcode);

	public ArrayList<GameReview> getAllGameReviews(int barcode);

	public GameReview writeGameReview(String user, int barcode, String review,
			int rank);
}
