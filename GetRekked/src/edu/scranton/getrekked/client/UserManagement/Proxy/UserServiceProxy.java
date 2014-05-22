package edu.scranton.getrekked.client.UserManagement.Proxy;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.scranton.getrekked.shared.User;

public class UserServiceProxy {
	public void getUser(int id, AsyncCallback<User> callbackGetUser) {
		UserServiceAsync userService = GWT.create(UserService.class);
		userService.getUser(id, callbackGetUser);
	}

	public void getAllUsers(AsyncCallback<ArrayList<User>> callbackGetUser) {
		UserServiceAsync userService = GWT.create(UserService.class);
		userService.getAllUsers(callbackGetUser);
	}

	public void addUser(User user, AsyncCallback<Void> callbackAddUser) {
		UserServiceAsync userService = GWT.create(UserService.class);
		userService.addUser(user, callbackAddUser);
	}

	public void deleteUsers(ArrayList<Integer> userIds,
			AsyncCallback<Void> callbackDeleteUser) {
		UserServiceAsync userService = GWT.create(UserService.class);
		userService.deleteUsers(userIds, callbackDeleteUser);
	}

	public void updateUser(User updatedUser,
			AsyncCallback<Void> callbackEditUser) {
		UserServiceAsync userService = GWT.create(UserService.class);
		userService.updateUser(updatedUser, callbackEditUser);
	}
}
