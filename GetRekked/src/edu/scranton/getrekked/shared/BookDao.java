package edu.scranton.getrekked.shared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.scranton.getrekked.database.Connection.DatabaseHelper;


public class BookDao {
    private Connection mConnection = null;
    private DatabaseHelper mDb;

    public BookDao() {
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

    
    public void insert(Book book) {
         insertBookInfo(book);
         insertBookGenres(book);
         insertBookAwards(book);
    }
    
    private void insertBookInfo(Book book) {
        String sql = "INSERT INTO Book VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement st = mConnection.prepareStatement(sql)) {

             st.setString(1, book.getIsbn());
             st.setString(2, book.getTitle());
             st.setString(3, book.getAuthor());
             st.setString(4, book.getPublisher());
             st.setString(5, book.getImageLink());
             st.setString(6, book.getLanguage());
             st.setInt(7, book.getNumOfPages());
             st.setString(8, book.getCopyRight());
             

             st.executeUpdate();              
        } catch (SQLException e) {
             e.printStackTrace();
        } 
    }
    
    private void insertBookGenres(Book book) {
    	String sql = "INSERT INTO Book_Genre VALUES(?, ?)";
    	for(int i = 0; i < book.getGenres().size(); i++) {
    		try(PreparedStatement st = mConnection.prepareStatement(sql)) {
    			st.setString(1, book.getIsbn());
    			st.setString(2, book.getGenres().get(i));
    			
    			st.executeUpdate();
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    	}
    }
    
    private void insertBookAwards(Book book) {
    	String sql = "INSERT INTO Book_Award VALUES(?, ?)";
    	for(int i = 0; i < book.getAwards().size(); i++) {
    		try(PreparedStatement st = mConnection.prepareStatement(sql)) {
    			st.setString(1, book.getIsbn());
    			st.setString(2, book.getAwards().get(i));
    			
    			st.executeUpdate();
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    	}
    }
    
    public int delete(String isbn) {
         int numofrows = 0;

         try(Statement st = mConnection.createStatement()) {
              String sql = "DELETE FROM Book WHERE isbn='" + isbn + "'";
              numofrows = st.executeUpdate(sql);
         } catch (SQLException e) {
              e.printStackTrace();
         }

         return numofrows;
    }


    public ArrayList<Book> getAllBooks() {
         ArrayList<Book> books = getBookInfo();
         books = getGenres(books);
         books = getAwards(books);
         return books;
    }
    
    private ArrayList<Book> getAwards(ArrayList<Book> books) {
    	for(int i = 0; i < books.size(); i++) {
            String sql = "SELECT * FROM Book_Awards WHERE isbn='" + books.get(i).getIsbn() + "'";

            try (Statement st = mConnection.createStatement()) {
                 ResultSet rs = st.executeQuery(sql);

                 while(rs.next()) {
                	 books.get(i).addAward(rs.getString("award"));
                 }
            } catch (SQLException e) {
                 e.printStackTrace();
            }

    	}
		return books;
	}


	private ArrayList<Book> getGenres(ArrayList<Book> books) {
    	for(int i = 0; i < books.size(); i++) {
            String sql = "SELECT * FROM Book_Genres WHERE isbn='" + books.get(i).getIsbn() + "'";

            try (Statement st = mConnection.createStatement()) {
                 ResultSet rs = st.executeQuery(sql);

                 while(rs.next()) {
                	 books.get(i).addGenre(rs.getString("genre"));
                 }
            } catch (SQLException e) {
                 e.printStackTrace();
            }

    	}
		return books;
	}


	private ArrayList<Book> getBookInfo() {
    	ArrayList<Book> books = new ArrayList<Book>();
        String sql = "SELECT * FROM Book ORDER BY isbn";

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

                  Book b = new Book(isbn);
                  b.setTitle(title);
                  b.setAuthor(author);
                  b.setPublisher(publisher);
                  b.setImageLink(image);
                  b.setLanguage(language);
                  b.setNumOfPages(numOfPages);
                  b.setCopyRight(copyright);
                  books.add(b);
             }
        } catch (SQLException e) {
             e.printStackTrace();
        }
    	
    	return books;
    }


    public Book getBook(String isbn) {
         Book b = null;

         String sql = "SELECT * FROM Book WHERE isbn='" + isbn + "'";
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

                  b = new Book(isbn);
                  b.setTitle(title);
                  b.setAuthor(author);
                  b.setPublisher(publisher);
                  b.setImageLink(image);
                  b.setLanguage(language);
                  b.setNumOfPages(numOfPages);
                  b.setCopyRight(copyright);    
              }
         } catch (SQLException e) {
              e.printStackTrace();
         }

         return b;
    }
}
