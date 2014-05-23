package edu.scranton.getrekked.client.UserManagement;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

import edu.scranton.getrekked.shared.User;

public class UpdateProfileView implements UpdateProfilePresenter.View {
	private DecoratorPanel mainPanel = null;
	private UpdateProfilePresenter dispatcher;
	private FlexTable userTable = new FlexTable();
	private TextBox userNameBox;
	private TextBox passwordBox;
	private TextBox firstNameBox;
	private TextBox lastNameBox;
	private TextBox emailBox;
	private TextBox phoneNumberBox;
	private TextBox dateOfBirthBox;
	private TextBox genderBox;
	private TextBox addressBox;
	private User user;

	public UpdateProfileView(UpdateProfilePresenter presenter) {
		this.dispatcher = presenter;
		mainPanel = new DecoratorPanel();
		HorizontalPanel menuPanel = new HorizontalPanel();
		Button updateUserButton = new Button("Update");
		Button cancelButton = new Button("Cancel");
		menuPanel.add(updateUserButton);
		menuPanel.add(cancelButton);
		updateUserButton.addClickHandler(new UpdateUserButtonClickHandler());
		cancelButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dispatcher.cancelOperation();
			}
		});
		userTable = new FlexTable();
		firstNameBox = new TextBox();
		lastNameBox = new TextBox();
		emailBox = new TextBox();
		userTable.setWidget(0, 0, new Label("First Name"));
		userTable.setWidget(0, 1, firstNameBox);
		userTable.setWidget(1, 0, new Label("Last Name"));
		userTable.setWidget(1, 1, lastNameBox);
		userTable.setWidget(2, 0, new Label("Email"));
		userTable.setWidget(2, 1, emailBox);

		FlexTable contentTable = new FlexTable();
		contentTable.setWidget(0, 0, menuPanel);
		contentTable.setWidget(1, 0, userTable);

		mainPanel.add(contentTable);
	}

	public void display() {
		// resetInputBoxes();
		RootPanel.get().clear();
		RootPanel.get().add(mainPanel);
	}

	public void setData(User user) {
		this.user = user;
	}

	// private void resetInputBoxes() {
	// firstNameBox.setText(user.getFirstName());
	// lastNameBox.setText(user.getLastName());
	// emailBox.setText(user.getEmail());
	// }
	public void setPresenter(UpdateProfilePresenter presenter) {
		this.dispatcher = presenter;
	}

	private User getStudentInfo() {
		String userName = userNameBox.getText();
		String password = passwordBox.getText();
		String firstName = firstNameBox.getText();
		String lastName = lastNameBox.getText();
		String email = emailBox.getText();
		String number = phoneNumberBox.getText();
		String dob = dateOfBirthBox.getText();
		String gender = genderBox.getText();
		String address = addressBox.getText();
		User user = new User(userName, password);
		user.setFirst_name(firstName);
		user.setLast_name(lastName);
		user.setEmail(email);
		user.setPhone_number(number);
		user.setDate_of_birth(dob);
		user.setGender(gender.charAt(0));
		user.setAddress(address);
		return user;
	}

	private class UpdateUserButtonClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			User user = getStudentInfo();
			dispatcher.updateUser(user);
		}
	}
}
