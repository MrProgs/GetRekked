package edu.scranton.getrekked.client.UserContentManagement.Proxy;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.scranton.getrekked.shared.User;

@RemoteServiceRelativePath("userContentService")
public interface UserContentService extends RemoteService {
	public User getUser(int id);

	public ArrayList<User> getAllUsers();

	public void addUser(User user);

	public void deleteUsers(ArrayList<Integer> userName);

	public void updateUser(User updatedUser);
}