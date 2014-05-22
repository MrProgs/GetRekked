package edu.scranton.getrekked.server.Authentication;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.scranton.getrekked.client.Authentication.Proxy.AuthenticationService;
import edu.scranton.getrekked.shared.User;

@SuppressWarnings("serial")
public class AuthenticationServiceImpl extends RemoteServiceServlet implements
		AuthenticationService {
	ArrayList<User> users = new ArrayList<User>();
	int nextStudentId = 45; // used to assign unique ids for students

	// public AuthenticationServiceImpl() {
	// // Create a list of users
	// users = new ArrayList<User>();
	// User user = new User("smith", "lsc090");
	// users.add(user);
	// user = new User("jordan", "lsc091");
	// users.add(user);
	// user = new User("woods", "lsc092");
	// users.add(user);
	// }
	@Override
	public User authenticate(String userName, String password) {
		for (User u : users) {
			if (u.getUserName().equals(userName)
					&& u.getPassword().equals(password))
				return u;
		}
		return null;
	}
}
