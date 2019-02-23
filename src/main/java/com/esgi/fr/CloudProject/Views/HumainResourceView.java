package com.esgi.fr.CloudProject.Views;

import java.util.Arrays;
import java.util.List;

import com.esgi.fr.CloudProject.Controller.RequestHttp;
import com.esgi.fr.CloudProject.Model.Holiday;
import com.esgi.fr.CloudProject.Model.User;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.vaadin.navigator.View;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.MenuBar.MenuItem;

public class HumainResourceView extends CssLayout implements View {
	
	
	HumainResourceView() {
		VerticalLayout centeringLayout = new VerticalLayout();
		centeringLayout.setStyleName("center");

		// Have some data
		User[] users = geAllUser();

		// Create a grid bound to the list
		Grid<User> grid = new Grid<>();
		grid.setItems(users);
		grid.addColumn(User::getLastName).setCaption("Nom");
		grid.addColumn(User::getFirstName).setCaption("Prénom");
		grid.addColumn(User::getEmail).setCaption("E-mail");
		grid.setResponsive(true);

		centeringLayout.addComponent(grid);
		addComponents(centeringLayout);
	}
	
	private User[] geAllUser() {
		
		String res = RequestHttp.getResponse("systemusers");		
		JsonObject JObjet = new JsonParser().parse(res).getAsJsonObject();
		JsonElement jsonElement = JObjet.get("results");
		User[] allUser = new Gson().fromJson(jsonElement, User[].class);
		return allUser;
	}
	
}
