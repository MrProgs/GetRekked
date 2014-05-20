package edu.scranton.getrekked.ReviewManagement;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;


public class ReviewView implements ReviewPresenter.View{
	private DecoratorPanel mainPanel = null;
	private ReviewPresenter dispatcher;
	private FlexTable reviewTable = new FlexTable();
	private TextBox reviewBox;
	private TextBox rankingBox;
	
	public ReviewView(ReviewPresenter presenter){
		  this.dispatcher = presenter;
	      mainPanel = new DecoratorPanel();
	      HorizontalPanel menuPanel = new HorizontalPanel();
	      Button reviewButton = new Button("Save");
	      Button cancelButton = new Button("Cancel");
	      menuPanel.add(reviewButton);
	      menuPanel.add(cancelButton);
	      reviewButton.addClickHandler(new ReviewButtonClickHandler());
	      cancelButton.addClickHandler(new ClickHandler() {
	         public void onClick(ClickEvent event) {
	            dispatcher.cancelOperation();
	         }
	      });
	      
	      reviewTable = new FlexTable();
	      reviewBox = new TextBox();
	      rankingBox = new TextBox();
	      reviewTable.setWidget(0, 0, new Label("Write review: "));
	      reviewTable.setWidget(0, 1, reviewBox);
	      reviewTable.setWidget(1, 0, new Label("Rank (0-5): "));
	      reviewTable.setWidget(1,  1, rankingBox);
	}
	
	public void display() {
	      resetInputBoxes();
	      RootPanel.get().clear();
	      RootPanel.get().add(mainPanel);
	}
	
	private void resetInputBoxes() {
	      reviewBox.setText("");   
	}
	
	public void setPresenter(ReviewPresenter presenter) {
	      this.dispatcher = presenter;
	}
	
	private class ReviewButtonClickHandler implements ClickHandler {
	      public void onClick(ClickEvent event) {
	         String review = reviewBox.getText();
	         String ranking = rankingBox.getText();
	         dispatcher.writeReview(review, ranking);
	      }
	}
}
