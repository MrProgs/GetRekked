package edu.scranton.getrekked.client.UserManagement;

import java.util.HashMap;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.scranton.getrekked.client.AppController;
import edu.scranton.getrekked.client.UserManagement.Proxy.UserServiceProxy;
import edu.scranton.getrekked.shared.User;

public class CreateProfilePresenter {
	public static interface View {
		public void display();
	}

	private View view;
	private UserServiceProxy userServiceProxy = null;
	private HashMap<String, String> intent = new HashMap<String, String>();

	public CreateProfilePresenter(UserServiceProxy proxy) {
		userServiceProxy = proxy;
	}

	public void addUser(User user) {
		AsyncCallback<Void> callbackAddStudent = new AsyncCallback<Void>() {

			public void onFailure(Throwable caught) {
				System.out.println("server error");
				intent.put("action", "createProfile");
				AppController.instance().go(intent);
			}

			public void onSuccess(Void x) {
				intent.put("action", "login");
				AppController.instance().go(intent);
			}
		};
		System.out.println(user.toString());
		userServiceProxy.addUser(user, callbackAddStudent);
	}

	public void setView(View view) {
		this.view = view;
	}

	public void cancelOperation() {
		// the user canceled the add student operation
		System.out.println("Add User operation cancelled");
		intent.put("action", "login");
		AppController.instance().go(intent);
	}

	public void begin() {
		// check if the user has successfully logged in.
		if (AppController.instance().isUserLoggedIn()) {
			this.view.display();
		} else {
			intent.put("action", "login");
			AppController.instance().go(intent);
		}
	}
}
