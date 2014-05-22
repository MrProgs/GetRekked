package edu.scranton.getrekked.client.UserContentManagement.Proxy;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.scranton.getrekked.client.UserContentManagement.Proxy.UserContentService;
import edu.scranton.getrekked.client.UserContentManagement.Proxy.UserContentServiceAsync;
import edu.scranton.getrekked.shared.User;

public class UserContentServiceProxy {
	public void getUser(int id, AsyncCallback<User> callbackGetUser) {
		UserContentServiceAsync userContentService = GWT.create(UserContentService.class);
		userContentService.getUser(id, callbackGetUser);
	}

	public void getAllUsers(AsyncCallback<ArrayList<User>> callbackGetUser) {
		UserContentServiceAsync userContentService = GWT.create(UserContentService.class);
		userContentService.getAllUsers(callbackGetUser);
	}

	public void addUser(User user, AsyncCallback<Void> callbackAddUser) {
		UserContentServiceAsync userContentService = GWT.create(UserContentService.class);
		userContentService.addUser(user, callbackAddUser);
	}

	public void deleteUsers(ArrayList<Integer> userIds,
			AsyncCallback<Void> callbackDeleteUser) {
		UserContentServiceAsync userContentService = GWT.create(UserContentService.class);
		userContentService.deleteUsers(userIds, callbackDeleteUser);
	}

	public void updateUser(User updatedUser,
			AsyncCallback<Void> callbackEditUser) {
		UserContentServiceAsync userContentService = GWT.create(UserContentService.class);
		userContentService.updateUser(updatedUser, callbackEditUser);
	}
}
