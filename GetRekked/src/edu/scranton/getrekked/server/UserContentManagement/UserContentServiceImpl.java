package edu.scranton.getrekked.server.UserContentManagement;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.scranton.getrekked.client.UserContentManagement.Proxy.UserContentService;
import edu.scranton.getrekked.shared.User;

import java.util.ArrayList;
public class UserContentServiceImpl extends RemoteServiceServlet implements UserContentService {

	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUsers(ArrayList<Integer> userName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(User updatedUser) {
		// TODO Auto-generated method stub
		
	}
//needs different proxy for user management.
}
