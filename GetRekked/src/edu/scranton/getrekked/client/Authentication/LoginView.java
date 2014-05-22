package edu.scranton.getrekked.client.Authentication;

import java.util.HashMap;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

import edu.scranton.getrekked.client.AppController;

public class LoginView implements LoginPresenter.View {
	private DecoratorPanel mainPanel = null;
	private LoginPresenter presenter;
	private FlexTable userTable = new FlexTable();
	private TextBox userNameBox;
	private PasswordTextBox passwordBox;
	private HashMap<String, String> intent 
			= new HashMap<String, String>();

	public LoginView() {
		mainPanel = new DecoratorPanel();
		HorizontalPanel menuPanel = new HorizontalPanel();
		Button loginButton = new Button("Log in");
		Button cancelButton = new Button("Cancel");
		Button createUserButton = new Button("Register");
		menuPanel.add(loginButton);
		menuPanel.add(cancelButton);
		menuPanel.add(createUserButton);
		LoginButtonClickHandler handler = new LoginButtonClickHandler();
		loginButton.addClickHandler(handler);
		cancelButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				presenter.cancelOperation();
			}
		});
		createUserButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				intent.put("Action", "createProfile");
				AppController.instance().go(intent);
			}
		});
		userTable = new FlexTable();
		userNameBox = new TextBox();
		passwordBox = new PasswordTextBox();
		passwordBox.addKeyUpHandler(handler);
		userTable.setWidget(0, 0, new Label("User Name"));
		userTable.setWidget(0, 1, userNameBox);
		userTable.setWidget(1, 0, new Label("Password"));
		userTable.setWidget(1, 1, passwordBox);

		FlexTable contentTable = new FlexTable();
		contentTable.setWidget(0, 0, menuPanel);
		contentTable.setWidget(1, 0, userTable);

		mainPanel.add(contentTable);
	}

	public void display() {
		resetInputBoxes();
		RootPanel.get().clear();
		RootPanel.get().add(mainPanel);
	}

	private void resetInputBoxes() {
		userNameBox.setText("");
		passwordBox.setText("");
	}

	public void setPresenter(LoginPresenter presenter) {
		this.presenter = presenter;
	}

	private class LoginButtonClickHandler implements ClickHandler, KeyUpHandler {
		public void onClick(ClickEvent event) {
			authenticate();
		}

		public void onKeyUp(KeyUpEvent event) {
			if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
				authenticate();
			}
		}

		private void authenticate() {
			presenter
					.authenticate(userNameBox.getText(), passwordBox.getText());
		}
	}
}
