package edu.scranton.getrekked.server.Authentication;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.scranton.getrekked.client.Authentication.Proxy.AuthenticationService;
import edu.scranton.getrekked.shared.User;
import edu.scranton.getrekked.shared.UserDao;

@SuppressWarnings("serial")
public class AuthenticationServiceImpl extends RemoteServiceServlet implements AuthenticationService{
	public AuthenticationServiceImpl() {
		// Empty constructor
	}
	public User authenticate(String username, String password) {
		UserDao userDao = new UserDao();
		return userDao.authenticate(username, password);
	}

}
