package edu.scranton.getrekked.client.UserManagement;

import java.util.HashMap;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.scranton.getrekked.client.AppController;
import edu.scranton.getrekked.client.UserManagement.Proxy.UserServiceProxy;
import edu.scranton.getrekked.shared.User;

public class UpdateProfilePresenter {
	public static interface View {
		public void display();
	}
	
	private View view;
	private UserServiceProxy userServiceProxy = null;
	private HashMap<String, String> intent;
	
	public UpdateProfilePresenter(UserServiceProxy proxy) {
		this.userServiceProxy = proxy;
		
	}
	
	public void updateUser(User user){
		AsyncCallback<Void> callbackEditStudent = new AsyncCallback<Void>() {
			public void onFailure(Throwable caught) {
				System.out.println("server error");
				intent.put("action","home");
				AppController.instance().go(intent);
			}

			public void onSuccess(Void v) {
				intent.put("action","home");
				AppController.instance().go(intent);
			}
		};
		System.out.println(user.toString());
		userServiceProxy.updateUser(user, callbackEditStudent);
		this.intent.put("action", "home");
		AppController.instance().go(intent);
	}
	
	public void getStudentInfo(){
		AsyncCallback<User> callbackGetStudent = new AsyncCallback<User>() {

			public void onFailure(Throwable caught) {
				System.out.println("server error");
				intent.put("action","home");
				AppController.instance().go(intent);
			}

			public void onSuccess(User x) {
				((UpdateProfileView) view).setData(x);
				view.display();
			}
		};
		int studentID = Integer.parseInt(this.intent.get("studentID"));
		userServiceProxy.getUser(studentID, callbackGetStudent);
	}
	
	public void begin() {
		// check if the user has successfully logged in.
		if (AppController.instance().isUserLoggedIn()) {
			getStudentInfo();
		} else {
			intent.put("action", "login");
			AppController.instance().go(intent);
		}
	}

	public void cancelOperation() {
		intent.put("action", "home");
		// the user canceled the add student operation
		System.out.println("Edit Student operation cancelled");
		AppController.instance().go(intent);
	}
	
	public void setView(View view) {
		this.view = view;
	}
	
	public void setIntent(HashMap<String,String> intent){
		this.intent = intent;
	}
}
