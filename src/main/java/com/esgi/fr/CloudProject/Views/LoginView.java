package com.esgi.fr.CloudProject.Views;

import com.esgi.fr.CloudProject.Controller.Authentification;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.themes.ValoTheme;

public class LoginView extends CssLayout implements View {

	private TextField username;
	private PasswordField password;
	private Button login;
	private HolidaysView holidayView;


	public LoginView() {
		username = new TextField("Email");
		password = new PasswordField("Password");
		login = new Button("Login");

		buildUI();
	}

	private void buildUI() {
		addStyleName("login-screen");
		Component loginForm = buildLoginForm();
	
		VerticalLayout centeringLayout = new VerticalLayout();
		//	        centeringLayout.setMargin(false);
		//	        centeringLayout.setSpacing(false);
		centeringLayout.setStyleName("center");
		centeringLayout.addComponent(loginForm);
		centeringLayout.setComponentAlignment(loginForm,Alignment.BOTTOM_CENTER);
		addComponent(centeringLayout);

	}

	private Component buildLoginForm() {

		FormLayout loginForm = new FormLayout();

		loginForm.addStyleName("login-form");
		loginForm.setSizeUndefined();
		loginForm.setMargin(false);
		loginForm.addComponent(username);
		username.setWidth(15, Unit.EM);
		loginForm.addComponent(password);
		password.setWidth(15, Unit.EM);
		
		login.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub

				Boolean result = Authentification.authenticate("popol", "Azerty123@");

				if(result){
					Navigator n = event.getButton().getUI().getNavigator();
					n.navigateTo(MyUI.HOLIDAYVIEW);
				}
			}
		});
		CssLayout buttons = new CssLayout();
		buttons.setStyleName("buttons");
		loginForm.addComponent(buttons);
		buttons.addComponent(login);
		login.addStyleName(ValoTheme.BUTTON_FRIENDLY);

		
		return loginForm;
	}



}
