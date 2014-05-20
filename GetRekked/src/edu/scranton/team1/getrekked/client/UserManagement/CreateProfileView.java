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

public class CreateProfileView implements CreateProfilePresenter.View {
   private DecoratorPanel mainPanel = null;
   private CreateProfilePresenter presenter;
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
   
   public CreateProfileView(CreateProfilePresenter p) {
      this.presenter = p;
      mainPanel = new DecoratorPanel();
      HorizontalPanel menuPanel = new HorizontalPanel();
      Button addUserButton = new Button("Register");
      Button cancelButton = new Button("Cancel");
      menuPanel.add(addUserButton);
      menuPanel.add(cancelButton);
      addUserButton.addClickHandler(new AddUserButtonClickHandler());
      cancelButton.addClickHandler(new ClickHandler() {
         public void onClick(ClickEvent event) {
            presenter.cancelOperation();
         }
      });
      
      userTable = new FlexTable();
      firstNameBox = new TextBox();
      lastNameBox = new TextBox();
      emailBox = new TextBox();
      phoneNumberBox = new TextBox();
      dateOfBirthBox = new TextBox();
      genderBox = new TextBox();
      addressBox = new TextBox();
      userTable.setWidget(0, 0, new Label("First Name"));
      userTable.setWidget(0, 1, firstNameBox);
      userTable.setWidget(1, 0, new Label("Last Name"));
      userTable.setWidget(1, 1, lastNameBox);
      userTable.setWidget(2, 0, new Label("Email"));
      userTable.setWidget(2, 1, emailBox);
      userTable.setWidget(0, 0, new Label("Phone Number"));
      userTable.setWidget(0, 1, phoneNumberBox);
      userTable.setWidget(1, 0, new Label("Birth Date"));
      userTable.setWidget(1, 1, dateOfBirthBox);
      userTable.setWidget(2, 0, new Label("Gender"));
      userTable.setWidget(2, 1, genderBox);
      userTable.setWidget(2, 0, new Label("address"));
      userTable.setWidget(2, 1, addressBox);
      
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
      firstNameBox.setText("");
      lastNameBox.setText("");
      emailBox.setText("");
   }
   public void setPresenter(CreateProfilePresenter presenter) {
      this.presenter = presenter;
   }
   private User getUserInfo() {
      String userName = userNameBox.getText();
      String password = passwordBox.getText();
      String firstName = firstNameBox.getText();
      String lastName = lastNameBox.getText();
      String email = emailBox.getText();
      String number = phoneNumberBox.getText();
      String dob = dateOfBirthBox.getText();
      String gender = genderBox.getText();
      String address = addressBox.getText();
      return new User(userName, password, firstName, lastName, email,
    		  number, dob, gender, address);
   }
   private class AddUserButtonClickHandler implements ClickHandler {
      public void onClick(ClickEvent event) {
         User user = getUserInfo();
         presenter.addUser(user);
      }
   }
}
