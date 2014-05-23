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

import edu.scranton.getrekked.shared.Book;
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
		this.addButton = new Button("Add Book");
		this.deleteButton = new Button("Delete Book");
		this.editButton = new Button("Edit Book");
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

	public void setData(ArrayList<User> user, ArrayList<Book> book) {
		UserTable.removeAllRows();
		//User user = null;
		UserTable.setText(0, 1, "ChrisPolanco");
		UserTable.setText(0, 2, "Chris");
		UserTable.setText(0, 3, "Polanco");
		UserTable.setText(0, 4, "polancoc2@scranton.edu");
		for (int i = 0; i < book.size(); i++) {
			contentTable.setText(i, 0, book.get(i).getTitle());
		}
	}

	public void display() {
		RootPanel.get().clear();
		RootPanel.get().add(mainPanel);
	}

	private class AddButtonClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			presenter.addBook();
		}
	}

	private class DeleteButtonClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			// get the selected row and then send them the serve for deletion
		}
	}

	private class EditButtonClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String studentID = null;
			for (int i = 0; i < UserTable.getRowCount(); i++) {
				if (((CheckBox) UserTable.getWidget(i, 0)).getValue()) {
					studentID = UserTable.getText(i, 1);
					break;
				}
			}
			if (studentID != null) {
				presenter.editStudents(studentID);
			} else {
				return;
			}
		}
	}
}
