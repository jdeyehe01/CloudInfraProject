package com.esgi.fr.CloudProject.Views;

import com.esgi.fr.CloudProject.Controller.Authentification;
import com.esgi.fr.CloudProject.Controller.RequestHttp;
import com.esgi.fr.CloudProject.Model.Group;
import com.esgi.fr.CloudProject.Model.User;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.themes.ValoTheme;

public class LoginView extends CssLayout implements View {

	private TextField username;
	private PasswordField password;
	private Button login;
	private HolidaysView holidayView;
	private Group[] groupUser;

	
	public LoginView() {
		username = new TextField("Username");
		password = new PasswordField("Password");
		login = new Button("Login");

		buildUI();
	}

	private void buildUI() {
		addStyleName("login-screen");
		Component loginForm = buildLoginForm();
	
		VerticalLayout centeringLayout = new VerticalLayout();
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
				
				groupUser = getGroups("V2/usergroups");	
				
				if(username.getValue().isEmpty() || password.getValue().isEmpty()) {
					Notification.show("Certains champs sont vides", Type.ERROR_MESSAGE);
					return;
				}

				Boolean result = Authentification.authenticate(username.getValue(), password.getValue());

				if(result){

					String json = "{\"filter\" : [{\"username\" : \""+username.getValue()+"\"}]}";
					String res = RequestHttp.postResponse("search/systemusers", json);		
					JsonObject JObjet = new JsonParser().parse(res).getAsJsonObject();
					JsonElement jsonElement = JObjet.get("results");
					User[] user = new Gson().fromJson(jsonElement, User[].class);
					MyUI.LOGGED_USER = user[0];
					Navigator n = event.getButton().getUI().getNavigator();
					boolean isHRUser = isHumanResourceUser(MyUI.LOGGED_USER.get_id());

					if(!isHRUser) {
						n.navigateTo(MyUI.HOLIDAYVIEW);						
					}
					else {
						n.navigateTo(MyUI.RHVIEW);
					}
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

	

	private  Group[] getGroups(String url ) {
		String res = RequestHttp.getResponse(url);
		Group[] groupUser = new Gson().fromJson(res, Group[].class);
		return groupUser;
	}
	
	public boolean isHumanResourceUser(String idUser) {
//		https://console.jumpcloud.com/api/v2/usergroups/5c6874b745886d3955aa0856/membership
		
		String url = "V2/users/"+idUser+"/memberof";

		String jsonResult = RequestHttp.getResponse(url);		
		JsonArray jsonArray = new JsonParser().parse(jsonResult).getAsJsonArray();
//		JsonElement jsonElement = JObjet.get("id");
		String id = jsonArray.get(0).getAsJsonObject().get("id").getAsString();
		
		for(Group g : groupUser) {
			if(g.getId().equals(id) && g.getName().equals("TestGroup") ) {
				return true;
			}
		}
		return false;
	}
	


}
