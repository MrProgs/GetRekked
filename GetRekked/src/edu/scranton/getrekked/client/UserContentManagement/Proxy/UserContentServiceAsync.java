package edu.scranton.getrekked.client.UserContentManagement.Proxy;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.scranton.getrekked.shared.User;

public interface UserContentServiceAsync {
	void getUser(int id, AsyncCallback<User> callbackGetUser);

	void getAllUsers(AsyncCallback<ArrayList<User>> callbackGetAllUsers);

	void deleteUsers(ArrayList<Integer> studentIds,
			AsyncCallback<Void> callbackDeleteUser);

	void addUser(User student, AsyncCallback<Void> callback);

	void updateUser(User editedStudent, AsyncCallback<Void> callback);
}