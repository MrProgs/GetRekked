package edu.scranton.getrekked.shared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.lang.Integer;

import edu.scranton.getrekked.database.Connection.DatabaseHelper;

public class BookReviewDao {
	private Connection mConnection = null;
    private DatabaseHelper mDb;
    
    public BookReviewDao(){
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
    
    
    public void insertBookReview(String user, String isbn, String review,
			String rank){
    	String sql = "INSERT INTO book_review VALUES(?, ?, ?, ?)";
    	try (PreparedStatement st = mConnection.prepareStatement(sql)) {

            st.setString(1, user);
            st.setString(2, isbn);
            st.setString(3, rank);
            st.setString(4, review);
            st.executeUpdate();              
       } catch (SQLException e) {
            e.printStackTrace();
       } 
   
    }
    
    //public void getBookReview(Book book){
    	//String sql = "SELECT * FROM book_review where username ="
   // }
}
