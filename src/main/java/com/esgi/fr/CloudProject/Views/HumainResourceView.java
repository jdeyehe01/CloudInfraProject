package com.esgi.fr.CloudProject.Views;

import java.util.Arrays;
import java.util.List;

import com.esgi.fr.CloudProject.Model.User;
import com.vaadin.navigator.View;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.MenuBar.MenuItem;

public class HumainResourceView extends CssLayout implements View {
	
	private Component buildMenuBar() {
		MenuBar barMenu = new MenuBar();
		MenuItem employee = barMenu.addItem("Employer");
		MenuItem rh = barMenu.addItem("Ressource humaine");
		return barMenu;
	}

	HumainResourceView() {
		VerticalLayout centeringLayout = new VerticalLayout();
		centeringLayout.setStyleName("center");

		// Have some data
		List<User> people = Arrays.asList(
				new User("TOTO","TITI","TEST","TEST"),
				new User("TUTU","DUPOND","TT","YY"),
				new User("BOBY","BOBY","BOBY","BOBY")
				);

		// Create a grid bound to the list
		Grid<User> grid = new Grid<>();
		grid.setItems(people);
		grid.addColumn(User::getLastName).setCaption("Nom");
		grid.addColumn(User::getFirstName).setCaption("Prénom");
		grid.addColumn(User::getEmail).setCaption("E-mail");
		grid.addColumn(User::getFunction).setCaption("Fonction");

		centeringLayout.addComponent(grid);
		addComponents(buildMenuBar(),centeringLayout);
	}
}
