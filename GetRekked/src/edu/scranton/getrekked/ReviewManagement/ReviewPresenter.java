package edu.scranton.getrekked.ReviewManagement;

import java.util.HashMap;

import edu.scranton.getrekked.ReviewManagement.ReviewPresenter.View;
import edu.scranton.getrekked.client.AppController;

public class ReviewPresenter {
	public static interface View{
		public void display();
	}
	
	private View view;
	private HashMap<String,String> intent;
	
	public void cancelOperation() {
		// the user canceled the edit student operation
		System.out.println("Edit Student operation cancelled");
		this.intent.put("Action", "home");
		AppController.instance().go(intent);
	}
	
	public void setView(View view) {
		this.view = view;
	}
	
	public void setIntent(HashMap<String,String> intent){
		this.intent = intent;
	}
	
	public void begin() {
		// check if the user has successfully logged in.
		if (AppController.instance().isUserLoggedIn()) {
			//STUB
		} else {
			this.intent.put("Action", "login");
			AppController.instance().go(intent);
		}
	}
	
	public void writeReview(String review, String ranking){
		
	}
}
