package edu.scranton.getrekked.client;

import java.util.HashMap;
//import edu.scranton.bi.client.AppController;


import edu.scranton.getrekked.RecommendationManagement.RecommendationPresenter;
import edu.scranton.getrekked.RecommendationManagement.RecommendationView;
import edu.scranton.getrekked.ReviewManagement.ReviewPresenter;
import edu.scranton.getrekked.ReviewManagement.ReviewView;
import edu.scranton.getrekked.client.Authentication.LoginPresenter;
import edu.scranton.getrekked.client.Authentication.LoginView;
import edu.scranton.getrekked.client.UserManagement.CreateProfilePresenter;
import edu.scranton.getrekked.client.UserManagement.CreateProfileView;
import edu.scranton.getrekked.client.UserManagement.UpdateProfilePresenter;
import edu.scranton.getrekked.client.UserManagement.UpdateProfileView;
import edu.scranton.getrekked.client.UserManagement.ViewProfilePresenter;
import edu.scranton.getrekked.client.UserManagement.ViewProfileView;

public class AppController {
	private RecommendationView recommendationView = null;
	private RecommendationPresenter recommendationPresenter = null;
	private ReviewPresenter reviewPresenter = null;
	private ReviewView reviewView= null;
	private LoginPresenter loginPresenter = null;
	private LoginView loginView = null;
	private CreateProfilePresenter createProfilePresenter = null;
	private CreateProfileView createProfileView = null;
	private UpdateProfilePresenter updateProfilePresenter = null;
	private UpdateProfileView updateProfileView = null;
	private ViewProfilePresenter viewProfilePresenter = null;
	private ViewProfileView viewProfileView = null;
	
	private static AppController appController = null;
	
	
	public static AppController instance() {
		if (appController == null)
			appController = new AppController();

		return appController;
	}
	
	private AppController(){
		recommendationPresenter = new RecommendationPresenter();
		recommendationView = new RecommendationView(recommendationPresenter);
		reviewPresenter = new ReviewPresenter();
		reviewView = new ReviewView(reviewPresenter);
		loginPresenter = new LoginPresenter();
		loginView = new LoginView();
		createProfilePresenter = new CreateProfilePresenter();
		createProfileView = new CreateProfileView(createProfilePresenter);
		updateProfilePresenter = new UpdateProfilePresenter();
		updateProfileView = new UpdateProfileView(updateProfilePresenter);
		viewProfilePresenter = new ViewProfilePresenter();
		viewProfileView = new ViewProfileView(viewProfilePresenter);
		
	}
	
	public void go(HashMap<String,String> intent){
		if(intent.get("Action").equals("review")){
			reviewPresenter.begin();
		}
		if(intent.get("Action").equals("recommend")){
			recommendationPresenter.begin();
		}
		if(intent.get("Action").equals("login")){
			loginPresenter.begin();
		}
		if(intent.get("Action").equals("createProfile")){
			createProfilePresenter.begin();
		}
		if(intent.get("Action").equals("updateProfile")){
			updateProfilePresenter.begin();
		}
		if(intent.get("Action").equals("viewProfile")){
			viewProfilePresenter.begin();
		}
	}
}
