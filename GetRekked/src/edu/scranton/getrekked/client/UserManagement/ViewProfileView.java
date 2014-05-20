package edu.scranton.getrekked.client.UserManagement;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;

import edu.scranton.getrekked.shared.User;

public class ViewProfileView implements ViewProfilePresenter.View {
	private final Button addButton;
	private final Button deleteButton;
	private final Button editButton;
	private FlexTable UserTable;
	private final FlexTable contentTable;
	private ViewProfilePresenter presenter;
	private DecoratorPanel mainPanel;

	public ViewProfileView(ViewProfilePresenter presenter) {
		// DecoratorPanel decPanel = new DecoratorPanel();
		this.presenter = presenter;
		mainPanel = new DecoratorPanel();
		this.addButton = new Button("Add Student");
		this.deleteButton = new Button("Delete Selected Students");
		this.editButton = new Button("Edit Student");
		this.UserTable = new FlexTable();
		this.contentTable = new FlexTable();

		HorizontalPanel menuPanel = new HorizontalPanel();
		menuPanel.add(addButton);
		menuPanel.add(deleteButton);
		menuPanel.add(editButton);

		contentTable.setWidget(0, 0, menuPanel);
		contentTable.setWidget(1, 0, UserTable);
		// decPanel.add(contentTable);

		// mainPanel.add(decPanel);
		mainPanel.add(contentTable);

		addButton.addClickHandler(new AddButtonClickHandler());
		deleteButton.addClickHandler(new DeleteButtonClickHandler());
		editButton.addClickHandler(new EditButtonClickHandler());
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
			presenter.addStudent();
		}
	}

	private class DeleteButtonClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			// get the selected row and then send them the serve for deletion
			ArrayList<Integer> studentIDs = new ArrayList<Integer>();
			for (int i = 0; i < UserTable.getRowCount(); i++) {
				if (((CheckBox) UserTable.getWidget(i, 0)).getValue()) {
					studentIDs.add(new Integer(UserTable.getText(i, 1)));
				}
			}
			if (studentIDs.size() != 0) {
				presenter.deleteStudents(studentIDs);
			} else {
				return;
			}
		}
	}
	
	private class EditButtonClickHandler implements ClickHandler{
		public void onClick(ClickEvent event){
			String studentID = null;
			for (int i = 0; i < UserTable.getRowCount(); i++) {
				if (((CheckBox)UserTable.getWidget(i, 0)).getValue()) {
					studentID = UserTable.getText(i, 1);
					break;
					}
				}
			if (studentID != null) {
				presenter.editStudents(studentID);
				}
			else {
				return;
				}
			}
	}
}
