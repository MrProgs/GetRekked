package edu.scranton.getrekked.client.UserManagement;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.scranton.getrekked.client.AppController;
import edu.scranton.getrekked.client.UserManagement.Proxy.UserServiceProxy;
import edu.scranton.getrekked.shared.User;

public class ViewProfilePresenter {
	public static interface View {
		public void setData(ArrayList<User> students);
		public void display();
	}

	private View view = null;
	private UserServiceProxy userServiceProxy = null;
	private HashMap<String,String> intent = new HashMap<String,String>();

	public ViewProfilePresenter(UserServiceProxy proxy) {
		userServiceProxy = proxy;
	}	

	public void setView(View view) {
		this.view = view;
	}

	public void begin() {
		// check if the user has successfully logged in.
		if (AppController.instance().isUserLoggedIn()) {
			getAllUsers();
		} else {
			intent.put("Action","login");
			AppController.instance().go(intent);
		}
	}
	private void getAllUsers() {
		AsyncCallback<ArrayList<User>> callbackGetUsers = new AsyncCallback<ArrayList<User>>() {

			public void onFailure(Throwable caught) {
				System.out.println("server error");
				intent.put("Action", "home");
				AppController.instance().go(intent);
			}

			public void onSuccess(ArrayList<User> user) {
				view.setData(user);
				view.display();
			}
		};
		userServiceProxy.getAllUsers(callbackGetUsers);
	}
	
	public void addContent() {
		intent.put("Action", "addStudent");
		AppController.instance().go(intent);
	}

	public void deleteContent(ArrayList<Integer> studentIDs) {
		System.out.println(studentIDs.toString());
		AsyncCallback<Void> callbackDeleteStudents = new AsyncCallback<Void>() {

			public void onFailure(Throwable caught) {
				System.out.println("server error");
				intent.put("Action", "home");
				AppController.instance().go(intent);
			}

			public void onSuccess(Void v) {
				intent.put("Action", "home");
				AppController.instance().go(intent);
			}
		};
		userServiceProxy.deleteUsers(studentIDs, callbackDeleteStudents);
	}
	
	public void writeReview(String content){
		System.out.println(content.toString());
		this.intent.put("Action", "write review");
		this.intent.put("identifier", content);
		AppController.instance().go(intent);
	}
}
