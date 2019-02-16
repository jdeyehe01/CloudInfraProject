package com.esgi.fr.CloudProject.Views;

import com.vaadin.navigator.View;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;

public class SecretView implements View {
	public static final String NAME="secret";
	public SecretView() {
		//((Layout) getContent()).addComponent(new Label("Some private stuff."));
		Notification n = new Notification("notification");
		n.show("INTERDIT !!");
	}
}