package edu.scranton.getrekked.client.UserContentManagement;

import java.lang.Integer;
import java.util.ArrayList;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

import edu.scranton.getrekked.shared.Book;
import edu.scranton.getrekked.shared.Game;
import edu.scranton.getrekked.shared.Movie;

public class AddContentToListView implements AddContentToListPresenter.View{
	private DecoratorPanel mainPanel = null;
	private AddContentToListPresenter presenter;
	private FlexTable bookTable = new FlexTable();
	private FlexTable gameTable = new FlexTable();
	private FlexTable movieTable = new FlexTable();
	private TextBox bookTitleBox;
	private TextBox authorBox;
	private TextBox bookPublisherBox;
	private TextBox languageBox;
	private TextBox genreBox;
	private TextBox numOfPagesBox;
	private TextBox copyRightBox;
	private TextBox gameTitleBox;
	private TextBox gamePublisherBox;
	private TextBox ESRBBox;
	private TextBox releaseDateBox;
	private TextBox movieTitleBox;
	private TextBox releaseYearBox;
	private TextBox MPAARatingBox;
	private TextBox movieLanguageBox;
	private TextBox runTimeBox;
	private TextBox isbnBox;
	private TextBox gameBarcodeBox;

	public AddContentToListView(AddContentToListPresenter a) {
		this.presenter = a;
		mainPanel = new DecoratorPanel();
		HorizontalPanel menuPanel = new HorizontalPanel();
		Button addBookButton = new Button("Add Book");
		Button addMovieButton = new Button("Add Movie");
		Button addGameButton = new Button("Add Game");
		Button cancelButton = new Button("Cancel");
		menuPanel.add(addBookButton);
		menuPanel.add(cancelButton);
		menuPanel.add(addMovieButton);
		menuPanel.add(addGameButton);
		addBookButton.addClickHandler(new AddBookButtonClickHandler());
		addMovieButton.addClickHandler(new AddMovieButtonClickHandler());
		addGameButton.addClickHandler(new AddGameButtonClickHandler());
		cancelButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				presenter.cancelOperation();
			}
		});

		bookTable = new FlexTable();
		bookTitleBox = new TextBox();
		authorBox = new TextBox();
		bookPublisherBox = new TextBox();
		isbnBox = new TextBox();
		languageBox = new TextBox();
		genreBox = new TextBox();
		numOfPagesBox = new TextBox();
		copyRightBox = new TextBox();
		bookTable.setWidget(0, 0, new Label("Title"));
		bookTable.setWidget(0, 1, bookTitleBox);
		bookTable.setWidget(1, 0, new Label("Author"));
		bookTable.setWidget(1, 1, authorBox);
		bookTable.setWidget(2, 0, new Label("Publisher"));
		bookTable.setWidget(2, 1, bookPublisherBox);
		bookTable.setWidget(3, 0, new Label("ISBN"));
		bookTable.setWidget(3, 1, isbnBox);
		bookTable.setWidget(4, 0, new Label("Language"));
		bookTable.setWidget(4, 1, languageBox);
		bookTable.setWidget(5, 0, new Label("Genre"));
		bookTable.setWidget(5, 1, genreBox);
		bookTable.setWidget(6, 0, new Label("Number of Pages"));
		bookTable.setWidget(6, 1, numOfPagesBox);
		bookTable.setWidget(7, 0, new Label("CopyRight Date"));
		bookTable.setWidget(7, 1, copyRightBox);
		
		gameTable = new FlexTable();
		gameTitleBox = new TextBox();
		gamePublisherBox = new TextBox();
		gameBarcodeBox = new TextBox();
		ESRBBox = new TextBox();
		releaseDateBox = new TextBox();
		gameTable.setWidget(0, 0, new Label("Title"));
		gameTable.setWidget(0, 1, gameTitleBox);
		gameTable.setWidget(2, 0, new Label("Publisher"));
		gameTable.setWidget(2, 1, gamePublisherBox);
		gameTable.setWidget(3, 0, new Label("Barcode"));
		gameTable.setWidget(3, 1, gameBarcodeBox);
		gameTable.setWidget(4, 0, new Label("ESRB"));
		gameTable.setWidget(4, 1, ESRBBox);
		gameTable.setWidget(5, 0, new Label("Release Date"));
		gameTable.setWidget(5, 1, releaseDateBox);
		
		movieTable = new FlexTable();
		movieTitleBox = new TextBox();
		releaseYearBox = new TextBox();
		MPAARatingBox = new TextBox();
		movieLanguageBox = new TextBox();
		runTimeBox = new TextBox();
		movieTable.setWidget(0, 0, new Label("Title"));
		movieTable.setWidget(0, 1, movieTitleBox);
		movieTable.setWidget(1, 0, new Label("Release Year"));
		movieTable.setWidget(1, 1, releaseYearBox);
		movieTable.setWidget(2, 0, new Label("MPAA Rating"));
		movieTable.setWidget(2, 1, MPAARatingBox);
		movieTable.setWidget(3, 0, new Label("Language"));
		movieTable.setWidget(3, 1, movieLanguageBox);
		movieTable.setWidget(4, 0, new Label("runTime"));
		movieTable.setWidget(4, 1, runTimeBox);

		FlexTable contentTable = new FlexTable();
		contentTable.setWidget(0, 0, menuPanel);
		contentTable.setWidget(1, 0, bookTable);
		contentTable.setWidget(2, 0, gameTable);
		contentTable.setWidget(3, 0, movieTable);

		mainPanel.add(contentTable);
	}

	public void display() {
		//resetInputBoxes();
		RootPanel.get().clear();
		RootPanel.get().add(mainPanel);
	}

//	private void resetInputBoxes() {
//		bookPublisherBox.setText("");
//		languageBox.setText("");
//		genreBox.setText("");
//	}

	public void setPresenter(AddContentToListPresenter presenter) {
		this.presenter = presenter;
	}

	private Book getBookInfo() {
		String title = bookTitleBox.getText();
		String author = authorBox.getText();
		String publisher = bookPublisherBox.getText();
		String isbn = isbnBox.getText();
		String language = languageBox.getText();
		ArrayList<String> genres = new ArrayList<String>();
		genres.add(genreBox.getText());
		int numOfPages = Integer.valueOf(numOfPagesBox.getText());
		String copyRight = copyRightBox.getText();
		Book book = new Book(isbn);
		book.setAuthor(author);
		book.setCopyRight(copyRight);
		book.setTitle(title);
		book.setGenres(genres);
		book.setLanguage(language);
		book.setPublisher(publisher);
		book.setNumOfPages(numOfPages);
		return book;
	}

	private Game getGameInfo() {
		String title = gameTitleBox.getText();
		String publisher = gamePublisherBox.getText();
		int barcode = Integer.valueOf(gameBarcodeBox.getText());
		String esrb = ESRBBox.getText();
		int release_date = Integer.valueOf(releaseDateBox.getText());
		return new Game(barcode, publisher, esrb, release_date, title);
	}

	private Movie getMovieInfo() {
		String title = movieTitleBox.getText();
		int release_year = Integer.valueOf(releaseYearBox.getText());
		int MPAARating = Integer.valueOf(bookPublisherBox.getText());
		String language = languageBox.getText();
		int runtime = Integer.valueOf(runTimeBox.getText());
		Movie movie = new Movie(title, release_year);
		movie.setMPAA_rating(MPAARating);
		movie.setLanguage(language);
		movie.setRuntime(runtime);
		return movie;
	}

	private class AddBookButtonClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			Book book = getBookInfo();
			presenter.addBook(book);
		}
	}
	
	private class AddGameButtonClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			Game game = getGameInfo();
			presenter.addGame(game);
		}
	}
	
	private class AddMovieButtonClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			Movie movie = getMovieInfo();
			presenter.addMovie(movie);
		}
	}
}
