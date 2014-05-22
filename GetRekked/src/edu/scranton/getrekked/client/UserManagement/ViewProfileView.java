package edu.scranton.getrekked.client.UserManagement;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import edu.scranton.getrekked.shared.User;

public class ViewProfileView implements ViewProfilePresenter.View {
	private final String[] categories = {"Books", "Movies", "Games"};
	private final Button addContentButton;
	private final Button deleteContentButton;
	private final Button writeReviewButton;
	private FlexTable UserTable;
	private final FlexTable contentTable;
	private ViewProfilePresenter presenter;
	private DecoratorPanel mainPanel;
	private HorizontalPanel contentPanel = new HorizontalPanel();

	public ViewProfileView(ViewProfilePresenter presenter) {
		// DecoratorPanel decPanel = new DecoratorPanel();
		this.presenter = presenter;
		mainPanel = new DecoratorPanel();
		this.addContentButton = new Button("Add Content");
		this.deleteContentButton = new Button("Delete Content");
		this.writeReviewButton = new Button("Write Review");
		this.UserTable = new FlexTable();
		this.contentTable = new FlexTable();

		contentTable.add(addContentButton);
		contentTable.add(deleteContentButton);
		contentTable.add(writeReviewButton);

		contentPanel.setSpacing(20);
		contentPanel = (HorizontalPanel) onInitialize();
		
		contentTable.setWidget(0, 0, contentPanel);
		contentTable.setWidget(1, 0, UserTable);
		// decPanel.add(contentTable);

		// mainPanel.add(decPanel);
		mainPanel.add(contentTable);

		addContentButton.addClickHandler(new AddButtonClickHandler());
		deleteContentButton.addClickHandler(new DeleteButtonClickHandler());
		writeReviewButton.addClickHandler(new WriteReviewButtonClickHandler());
	}
	
	public Widget onInitialize() {
		final ListBox dropBox = new ListBox(false);
		for(int i = 0; i <= categories.length; i++){
			dropBox.addItem(categories[i]);
		}
		
		VerticalPanel dropBoxPanel = new VerticalPanel();
	    dropBoxPanel.setSpacing(4);
	    dropBoxPanel.add(dropBox);
	    contentPanel.add(dropBoxPanel);
		
	    final ListBox multiBox = new ListBox(true);
	    multiBox.setWidth("11em");
	    multiBox.setVisibleItemCount(10);
	    VerticalPanel multiBoxPanel = new VerticalPanel();
	    multiBoxPanel.setSpacing(4);
	    multiBoxPanel.add(multiBox);
	    contentPanel.add(multiBoxPanel);
	    
	    dropBox.addChangeHandler(new ChangeHandler() {
	        public void onChange(ChangeEvent event) {
	          showCategory(multiBox, dropBox.getSelectedIndex());
	        }
	      });
	    
	    showCategory(multiBox, 0);
	    multiBox.ensureDebugId("cwListBox-multiBox");
		return contentPanel;
	}
	
	private void showCategory(ListBox listBox, int category) {
	    listBox.clear();
	   // String[] listData = null;
	    switch (category) {
	      case 0:
	        //listData = null;
	        break;
	      case 1:
	        //listData = null;
	        break;
	      case 2:
	        //listData = null;
	        break;
	    }
	    //for (int i = 0; i < listData.length; i++) {
	      listBox.addItem("Books");
//	      listBox.addItem(listData[i]);
	    //}
	  }

	public void setPresenter(ViewProfilePresenter presenter) {
		this.presenter = presenter;
	}

	public void setData(ArrayList<User> users) {
		UserTable.removeAllRows(); // clear the student from previous use
		User user = null;
		for (int i = 0; i < users.size(); i++) {
			user = users.get(i);
			UserTable.setWidget(i, 0, new CheckBox());
			UserTable
					.setText(i, 1, new Integer(user.getUserName()).toString());
			UserTable.setText(i, 2, user.getLast_name());
			UserTable.setText(i, 3, user.getFirst_name());
			UserTable.setText(i, 4, user.getEmail());
		}
	}

	public void display() {
		RootPanel.get().clear();
		RootPanel.get().add(mainPanel);
	}

	private class AddButtonClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			presenter.addContent();
		}
	}

	private class DeleteButtonClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			// get the selected row and then send them the serve for deletion
			ArrayList<Integer> content = new ArrayList<Integer>();
			for (int i = 0; i < UserTable.getRowCount(); i++) {
				if (((CheckBox) UserTable.getWidget(i, 0)).getValue()) {
					content.add(new Integer(UserTable.getText(i, 1)));
				}
			}
			if (content.size() != 0) {
				presenter.deleteContent(content);
			} else {
				return;
			}
		}
	}
	
	private class WriteReviewButtonClickHandler implements ClickHandler{
		public void onClick(ClickEvent event){
			String content = null;
			for (int i = 0; i < UserTable.getRowCount(); i++) {
				if (((CheckBox)UserTable.getWidget(i, 0)).getValue()) {
					content = UserTable.getText(i, 1);
					break;
					}
				}
			if (content != null) {
				presenter.writeReview(content);
				}
			else {
				return;
				}
			}
	}
}
