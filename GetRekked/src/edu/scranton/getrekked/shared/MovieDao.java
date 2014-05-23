package edu.scranton.getrekked.shared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.scranton.getrekked.database.Connection.DatabaseHelper;


public class MovieDao {
    private Connection mConnection = null;
    private DatabaseHelper mDb;

    public MovieDao() {
         String host = "134.198.169.32";
         String dbName = "dbName";
         String username = "username";
         String password = "password";

         this.mDb = new DatabaseHelper(host, dbName, username, password);
         this.mConnection = this.mDb.getConnection();
    }


    public void close() {
         this.mDb.close();
    }

    
    public void insert(Movie Movie) {
         insertMovieInfo(Movie);
         insertMovieGenres(Movie);
         insertMovieAwards(Movie);
    }
    
    private void insertMovieInfo(Movie Movie) {
        String sql = "INSERT INTO Movie VALUES(?, ?, ?, ?, ?, ?)";
        try (PreparedStatement st = mConnection.prepareStatement(sql)) {

             st.setString(1, Movie.getTitle());
             st.setInt(2, Movie.getRelease_year());
             st.setString(3, Movie.getImageLink());
             st.setString(4, Integer.toString(Movie.getMPAA_rating()));
             st.setString(5, Movie.getLanguage());
             st.setString(6, Integer.toString(Movie.getRuntime()));
             

             st.executeUpdate();              
        } catch (SQLException e) {
             e.printStackTrace();
        } 
    }
    //there is no movie_genre tablel!
    private void insertMovieGenres(Movie Movie) {
    	String sql = "INSERT INTO Movie_Genre VALUES(?, ?)";
    	for(int i = 0; i < Movie.getGenres().size(); i++) {
    		try(PreparedStatement st = mConnection.prepareStatement(sql)) {
    			st.setString(1, Movie.getTitle());
    			st.setString(2, Movie.getGenres().get(i));
    			
    			st.executeUpdate();
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    	}
    }
    
    private void insertMovieAwards(Movie Movie) {
    	String sql = "INSERT INTO Movie_Award VALUES(?, ?)";
    	for(int i = 0; i < Movie.getAwards().size(); i++) {
    		try(PreparedStatement st = mConnection.prepareStatement(sql)) {
    			st.setString(1, Movie.getTitle());
    			st.setString(2, Movie.getAwards().get(i));
    			
    			st.executeUpdate();
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    	}
    }
    
    public int delete(String isbn) {
         int numofrows = 0;

         try(Statement st = mConnection.createStatement()) {
              String sql = "DELETE FROM Movie WHERE isbn='" + isbn + "'";
              numofrows = st.executeUpdate(sql);
         } catch (SQLException e) {
              e.printStackTrace();
         }

         return numofrows;
    }


    public ArrayList<Movie> getAllMovies() {
         ArrayList<Movie> Movies = getMovieInfo();
         Movies = getGenres(Movies);
         Movies = getAwards(Movies);
         return Movies;
    }
    
    private ArrayList<Movie> getAwards(ArrayList<Movie> Movies) {
    	for(int i = 0; i < Movies.size(); i++) {
            String sql = "SELECT * FROM Movie_Awards WHERE title='" + Movies.get(i).getTitle() + "'";

            try (Statement st = mConnection.createStatement()) {
                 ResultSet rs = st.executeQuery(sql);

                 while(rs.next()) {
                	 Movies.get(i).addAward(rs.getString("award"));
                 }
            } catch (SQLException e) {
                 e.printStackTrace();
            }

    	}
		return Movies;
	}


	private ArrayList<Movie> getGenres(ArrayList<Movie> Movies) {
    	for(int i = 0; i < Movies.size(); i++) {
            String sql = "SELECT * FROM Movie_Genres WHERE isbn='" + Movies.get(i).getIsbn() + "'";

            try (Statement st = mConnection.createStatement()) {
                 ResultSet rs = st.executeQuery(sql);

                 while(rs.next()) {
                	 Movies.get(i).addGenre(rs.getString("genre"));
                 }
            } catch (SQLException e) {
                 e.printStackTrace();
            }

    	}
		return Movies;
	}


	private ArrayList<Movie> getMovieInfo() {
    	ArrayList<Movie> Movies = new ArrayList<Movie>();
        String sql = "SELECT * FROM Movie ORDER BY isbn";

        try (Statement st = mConnection.createStatement()) {
             ResultSet rs = st.executeQuery(sql);

             while(rs.next()) {
                  String isbn = rs.getString("isbn");
                  String title = rs.getString("title");
                  String author = rs.getString("author");
                  String publisher = rs.getString("publisher");
                  String image = rs.getString("image");
                  String language = rs.getString("language");
                  int numOfPages = rs.getInt("number_of_pages");
                  String copyright = rs.getString("copyright");

                  Movie b = new Movie(isbn);
                  b.setTitle(title);
                  b.setAuthor(author);
                  b.setPublisher(publisher);
                  b.setImage(image);
                  b.setLanguage(language);
                  b.setNumberOfPages(numOfPages);
                  b.setCopyright(copyright);
                  Movies.add(b);
             }
        } catch (SQLException e) {
             e.printStackTrace();
        }
    	
    	return Movies;
    }


    public Movie getMovie(String isbn) {
         Movie b = null;

         String sql = "SELECT * FROM Movie WHERE isbn='" + isbn + "'";
         try(Statement st = mConnection.createStatement()) {
              ResultSet rs = st.executeQuery(sql);
              if(rs.next()){
                  String title = rs.getString("title");
                  String author = rs.getString("author");
                  String publisher = rs.getString("publisher");
                  String image = rs.getString("image");
                  String language = rs.getString("language");
                  int numOfPages = rs.getInt("number_of_pages");
                  String copyright = rs.getString("copyright");

                  b = new Movie(isbn);
                  b.setTitle(title);
                  b.setAuthor(author);
                  b.setPublisher(publisher);
                  b.setImage(image);
                  b.setLanguage(language);
                  b.setNumberOfPages(numOfPages);
                  b.setCopyright(copyright);    
              }
         } catch (SQLException e) {
              e.printStackTrace();
         }

         return b;
    }
}
