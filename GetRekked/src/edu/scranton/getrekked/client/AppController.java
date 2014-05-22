package edu.scranton.getrekked.client;

import java.util.HashMap;
//import edu.scranton.bi.client.AppController;




import edu.scranton.getrekked.client.Authentication.LoginPresenter;
import edu.scranton.getrekked.client.Authentication.LoginView;
import edu.scranton.getrekked.client.Authentication.Proxy.AuthenticationServiceProxy;
import edu.scranton.getrekked.client.ContentManagement.Proxy.ContentServiceProxy;
import edu.scranton.getrekked.client.RecommendationManagement.RecommendationPresenter;
import edu.scranton.getrekked.client.RecommendationManagement.RecommendationView;
import edu.scranton.getrekked.client.ReviewManagement.ReadReviewPresenter;
import edu.scranton.getrekked.client.ReviewManagement.ReadReviewView;
import edu.scranton.getrekked.client.ReviewManagement.WriteReviewPresenter;
import edu.scranton.getrekked.client.ReviewManagement.WriteReviewView;
import edu.scranton.getrekked.client.ReviewManagement.Proxy.ReviewServiceProxy;
import edu.scranton.getrekked.client.UserContentManagement.AddContentToListPresenter;
import edu.scranton.getrekked.client.UserContentManagement.AddContentToListView;
import edu.scranton.getrekked.client.UserManagement.CreateProfilePresenter;
import edu.scranton.getrekked.client.UserManagement.CreateProfileView;
import edu.scranton.getrekked.client.UserManagement.UpdateProfilePresenter;
import edu.scranton.getrekked.client.UserManagement.UpdateProfileView;
import edu.scranton.getrekked.client.UserManagement.ViewProfilePresenter;
import edu.scranton.getrekked.client.UserManagement.ViewProfileView;
import edu.scranton.getrekked.client.UserManagement.Proxy.UserServiceProxy;
import edu.scranton.getrekked.shared.User;

public class AppController {
	private AuthenticationServiceProxy authenticationServiceProxy = null;
	private UserServiceProxy userServiceProxy = null;
	private ContentServiceProxy contentServiceProxy = null;
	private RecommendationView recommendationView = null;
	private RecommendationPresenter recommendationPresenter = null;
	private WriteReviewPresenter writeReviewPresenter = null;
	private WriteReviewView writeReviewView = null;
	private ReadReviewPresenter readReviewPresenter = null;
	private ReadReviewView readReviewView = null;
	private ReviewServiceProxy reviewServiceProxy = null;
	private LoginPresenter loginPresenter = null;
	private LoginView loginView = null;
	private CreateProfilePresenter createProfilePresenter = null;
	private CreateProfileView createProfileView = null;
	private UpdateProfilePresenter updateProfilePresenter = null;
	private UpdateProfileView updateProfileView = null;
	private ViewProfilePresenter viewProfilePresenter = null;
	private ViewProfileView viewProfileView = null;
	private AddContentToListPresenter addContentToListPresenter = null;
	private AddContentToListView addContentToListView = null;

	private static AppController appController = null;

	private User currentUser = null;

	public static AppController instance() {
		if (appController == null)
			appController = new AppController();

		return appController;
	}

	private AppController() {
		userServiceProxy = new UserServiceProxy();
		reviewServiceProxy = new ReviewServiceProxy();
		authenticationServiceProxy = new AuthenticationServiceProxy();
		contentServiceProxy = new ContentServiceProxy();
		
		recommendationPresenter = new RecommendationPresenter();
		recommendationView = new RecommendationView(recommendationPresenter);
		
		writeReviewPresenter = new WriteReviewPresenter(reviewServiceProxy);
		writeReviewView = new WriteReviewView(writeReviewPresenter);
		writeReviewPresenter.setView(writeReviewView);
		
		readReviewPresenter = new ReadReviewPresenter(reviewServiceProxy);
		readReviewView = new ReadReviewView(readReviewPresenter);
		readReviewPresenter.setView(readReviewView);
		
		loginView = new LoginView();
		loginPresenter = new LoginPresenter(authenticationServiceProxy);
		loginPresenter.setView(loginView);
		loginView.setPresenter(loginPresenter);
		
		createProfilePresenter = new CreateProfilePresenter(userServiceProxy);
		createProfileView = new CreateProfileView(createProfilePresenter);
		createProfilePresenter.setView(createProfileView);
		
		updateProfilePresenter = new UpdateProfilePresenter(userServiceProxy);
		updateProfileView = new UpdateProfileView(updateProfilePresenter);
		updateProfilePresenter.setView(updateProfileView);
		
		viewProfilePresenter = new ViewProfilePresenter(userServiceProxy);
		viewProfileView = new ViewProfileView(viewProfilePresenter);
		viewProfilePresenter.setView(viewProfileView);
		
		addContentToListPresenter = new AddContentToListPresenter(contentServiceProxy);
		addContentToListView = new AddContentToListView(addContentToListPresenter);
		addContentToListPresenter.setView(addContentToListView);

	}

	public User getUser() {
		return currentUser;
	}

	public void setUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public boolean isUserLoggedIn() {
		return currentUser != null;
	}

	public void go(HashMap<String, String> intent) {
		if (intent.get("Action").equals("write review")) {
			writeReviewPresenter.begin();
		}
		if (intent.get("Action").equals("read review")) {
			readReviewPresenter.begin();
		}
		if (intent.get("Action").equals("recommend")) {
			recommendationPresenter.begin();
		}
		if (intent.get("Action").equals("login")) {
			loginPresenter.begin();
		}
		if (intent.get("Action").equals("createProfile")) {
			createProfilePresenter.begin();
		}
		if (intent.get("Action").equals("updateProfile")) {
			updateProfilePresenter.begin();
		}
		if (intent.get("Action").equals("home")) {
			viewProfilePresenter.begin();
		}
		if (intent.get("Action").equals("addContent")){
			addContentToListPresenter.begin();
		}
	}
}
