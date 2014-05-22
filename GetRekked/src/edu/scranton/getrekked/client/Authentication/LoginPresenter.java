package edu.scranton.getrekked.client.Authentication;

import java.util.HashMap;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.scranton.getrekked.client.AppController;
import edu.scranton.getrekked.client.Authentication.Proxy.AuthenticationServiceProxy;
import edu.scranton.getrekked.shared.User;

public class LoginPresenter {
	public static interface View {
		public void display();
	}

	private View view;
	private HashMap<String, String> intent = new HashMap<String, String>();
	private AuthenticationServiceProxy authenticationServiceProxy = null;

	public LoginPresenter(AuthenticationServiceProxy proxy) {
		authenticationServiceProxy = proxy;
	}

	public void setView(View view) {
		this.view = view;
	}

	public void authenticate(String userName, String password) {
		AsyncCallback<User> callbackAuthenticate = new AsyncCallback<User>() {
			public void onFailure(Throwable caught) {
				System.out.println("server error");
				intent.put("Action", "login");
				AppController.instance().go(intent);
			}

			public void onSuccess(User user) {
				AppController.instance().setUser(user);
				intent.put("Action", "home");
				AppController.instance().go(intent);
			}
		};
		authenticationServiceProxy.authenticate(userName, password, callbackAuthenticate);
	}

	public void cancelOperation() {
		// the user canceled the login operation
		System.out.println("Log in operation cancelled");
		intent.put("action", "login");
		AppController.instance().go(intent);
	}

	public void begin() {
		this.view.display();
	}
}
