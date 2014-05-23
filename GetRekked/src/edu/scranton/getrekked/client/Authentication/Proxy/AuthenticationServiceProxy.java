package edu.scranton.getrekked.client.Authentication.Proxy;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.scranton.getrekked.shared.User;

public class AuthenticationServiceProxy {
	public void authenticate(String userName, String password,AsyncCallback<User> callbackAuthenticate) {
		AuthenticationServiceAsync authenticationService = GWT.create(AuthenticationService.class);
		authenticationService.authenticate(userName, password,callbackAuthenticate);
	}
}
