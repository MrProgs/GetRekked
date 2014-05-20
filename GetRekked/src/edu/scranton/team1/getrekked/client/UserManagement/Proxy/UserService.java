package edu.scranton.getrekked.client.UserManagement.Proxy;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.scranton.getrekked.shared.User;

@RemoteServiceRelativePath("userService")
public interface UserService extends RemoteService {
   public User getUser(int id);
   public ArrayList<User> getAllUsers();
   public void addUser(User user);
   public void deleteUsers(ArrayList<Integer> userName);
   public void updateUser(User updatedUser);
}