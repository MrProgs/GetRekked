package edu.scranton.getrekked.shared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
    
    public void insertBookReview(BookReview review){
    	insertBookReviewInfo(review);
    }
    
    public void insertBookReviewInfo(BookReview review){
    	String sql = "INSERT INTO book_review VALUES(?, ?, ?, ?)";
    }
}
