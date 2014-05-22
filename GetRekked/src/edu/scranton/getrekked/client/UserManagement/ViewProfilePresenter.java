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
	private HashMap<String, String> intent = new HashMap<String, String>();

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
			intent.put("action", "login");
			AppController.instance().go(intent);
		}
	}

	private void getAllUsers() {
		AsyncCallback<ArrayList<User>> callbackGetUsers = new AsyncCallback<ArrayList<User>>() {

			public void onFailure(Throwable caught) {
				System.out.println("server error");
				intent.put("action", "home");
				AppController.instance().go(intent);
			}

			public void onSuccess(ArrayList<User> user) {
				view.setData(user);
				view.display();
			}
		};
		userServiceProxy.getAllUsers(callbackGetUsers);
	}

	public void addStudent() {
		System.out.println("add student");
		intent.put("action", "addStudent");
		AppController.instance().go(intent);
	}

	public void deleteStudents(ArrayList<Integer> studentIDs) {
		System.out.println("delete students");
		System.out.println(studentIDs.toString());
		AsyncCallback<Void> callbackDeleteStudents = new AsyncCallback<Void>() {

			public void onFailure(Throwable caught) {
				System.out.println("server error");
				intent.put("action", "home");
				AppController.instance().go(intent);
			}

			public void onSuccess(Void v) {
				System.out.println("Students deleted");
				intent.put("action", "home");
				AppController.instance().go(intent);
			}
		};
		userServiceProxy.deleteUsers(studentIDs, callbackDeleteStudents);
	}

	public void editStudents(String studentID) {
		System.out.println("edit student");
		System.out.println(studentID.toString());
		this.intent.put("action", "editStudent");
		this.intent.put("studentID", studentID);
		AppController.instance().go(intent);
	}
}
