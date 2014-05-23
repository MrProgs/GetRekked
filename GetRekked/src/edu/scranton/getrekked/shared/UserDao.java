package edu.scranton.getrekked.shared;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.scranton.getrekked.database.Connection.DatabaseHelper;


public class UserDao {
    private Connection mConnection = null;
    private DatabaseHelper mDb;

    public UserDao() {
         String host = "134.198.169.32";
         String dbName = "team12014";
         String username = "team12014";
         String password = "lsc090team1";

         this.mDb = new DatabaseHelper(host, dbName, username, password);
         this.mConnection = this.mDb.getConnection();
    }


    public void close() {
         this.mDb.close();
    }

    public User authenticate(String username, String password) {
    	String sql = "SELECT username, pass FROM Users WHERE username='"+username+"';";
    	try {
    		//User currentUser 
    		Statement st = mConnection.createStatement();
    		ResultSet result = st.executeQuery(sql);
   
    		if(result.next()) {
    			String pass = result.getString("pass");
    			// Now we have enough info to create a User object
    			User currentUser = new User();
    			currentUser.setUsername(username);
    			currentUser.setPassword(pass);
    			
    			if(!currentUser.getPassword().equals(password)) return null;
    			currentUser.setFirst_name(result.getString("first_name"));
    			currentUser.setLast_name(result.getString("last_name"));
    			currentUser.setEmail(result.getString("email"));
    			currentUser.setDate_of_birth(result.getString("date_of_birth"));
    			currentUser.setGender(result.getString("gender").charAt(0));
    			currentUser.setPhone_number(result.getString("phone_number"));
    			currentUser.setAddress(result.getString("address"));
    			return currentUser;
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return null;
    }
}