package edu.scranton.getrekked.database.interfaces;

public interface UserInterface {

	// Username and password will be passed through the User constructor
	
	// Getters and Setters
	
	// Password
	public String getPassword();
	
	// First Name
	public String getFirstName();
	public void setFirstName(String firstName);
	
	// Last Name
	public String getLastName();
	public void setLastName(String lastName);
	
	// Email
	public String getEmail();
	public void setEmail(String email);
	
	// Date of Birth
	public String getDateOfBirth();
	public void setDateOfBirth(String dateOfBirth);
	
	// Gender
	public char getGender();
	public void setGender(char gender);
	
	// Phone number
	public String getPhoneNumber();
	public void setPhoneNumber(String phoneNumber);
	
	// Address
	public String getAddress();
	public void setAddress(String address);
}
