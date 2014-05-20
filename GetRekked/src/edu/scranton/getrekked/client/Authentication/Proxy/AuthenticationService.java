package edu.scranton.getrekked.client.Authentication.Proxy;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.scranton.getrekked.shared.User;

@RemoteServiceRelativePath("authenticationService")
public interface AuthenticationService extends RemoteService {
   public User authenticate(String userName, String password);
}