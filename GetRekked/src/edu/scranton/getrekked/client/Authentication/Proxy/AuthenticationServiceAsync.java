package edu.scranton.getrekked.client.Authentication.Proxy;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.scranton.getrekked.shared.User;

public interface AuthenticationServiceAsync {
	void authenticate(String userName, String passwrod,
			AsyncCallback<User> callbackAuthenticate);
}