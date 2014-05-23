package edu.scranton.getrekked.server.ReviewManagement;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.ArrayList;

import edu.scranton.getrekked.client.ReviewManagement.Proxy.ReviewService;
import edu.scranton.getrekked.shared.BookReview;
import edu.scranton.getrekked.shared.BookReviewDao;
import edu.scranton.getrekked.shared.GameReview;
import edu.scranton.getrekked.shared.MovieReview;

public class ReviewServiceImpl extends RemoteServiceServlet implements
ReviewService {

	@Override
	public MovieReview getMovieReview(String user, String title,
			int release_year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<MovieReview> getAllMovieReviews(String title,
			int release_year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovieReview writeMovieReview(String user, String title,
			int release_year, String review, int rank) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookReview getBookReview(String user, int isbn) {
		//TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BookReview> getAllBookReviews(int isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookReview writeBookReview(String user, String isbn, String review,
			String rank) {
		BookReviewDao dao = new BookReviewDao();
		dao.insertBookReview(user, isbn, review, rank);
		return null;
	}

	@Override
	public GameReview getGameReview(String user, int barcode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<GameReview> getAllGameReviews(int barcode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameReview writeGameReview(String user, int barcode, String review,
			int rank) {
		// TODO Auto-generated method stub
		return null;
	}

}
