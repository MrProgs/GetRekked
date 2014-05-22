package edu.scranton.getrekked.server.UserManagement;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.scranton.getrekked.client.UserManagement.Proxy.UserService;
import edu.scranton.getrekked.shared.User;

import java.util.ArrayList;

public class UserServiceImpl extends RemoteServiceServlet implements UserService{

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

}
