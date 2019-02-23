package com.esgi.fr.CloudProject.Views;

import com.esgi.fr.CloudProject.Model.User;
import com.vaadin.navigator.View;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class EmployeeView extends CssLayout implements View{
	
	private Label welcome;
		
	
	public EmployeeView() {
		buildUI();
			
	}
	private void buildUI() {

		addStyleName("login-screen");
		welcome = new Label("Bienvenue "+ MyUI.LOGGED_USER.getFirstName() +" "+ MyUI.LOGGED_USER.getLastName());
		VerticalLayout centeringLayout = new VerticalLayout();
		//	        centeringLayout.setMargin(false);
		//	        centeringLayout.setSpacing(false);
		centeringLayout.setStyleName("center");
		centeringLayout.addComponents(welcome);
		centeringLayout.setComponentAlignment(welcome,Alignment.BOTTOM_CENTER);
		addComponent(centeringLayout);
		
	}
}
