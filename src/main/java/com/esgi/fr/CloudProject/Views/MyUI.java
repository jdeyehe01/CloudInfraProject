package com.esgi.fr.CloudProject.Views;

import javax.servlet.annotation.WebServlet;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.esgi.fr.CloudProject.Model.User;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {
	public static final String HOLIDAYVIEW = "holiday";
	public static final String RHVIEW = "ressourceHumaine";
	private Navigator navigator;
    User loggedInUser;


    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	Client client = ClientBuilder.newClient();
    	WebTarget webTarget = client.target("https://reqres.in/api/users/2");
    	Invocation.Builder incationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
    	Response response = incationBuilder.get();
    	String res = response.readEntity(String.class);
    	
    	setSizeFull();
        getPage().setTitle("Cloud Project");
        navigator = new Navigator(this, this);
        System.out.println(res);
//        User toto = new User("BOBY","BOBY","BOBY","BOBY");
//        this.setLoggedInUser(toto);
        navigator.addViewChangeListener(new ViewChangeListener() {
			
			@Override
			public boolean beforeViewChange(ViewChangeEvent event) {
				if(  ( (MyUI)UI.getCurrent()).getLoggedInUser() == null && event.getNewView() instanceof HumainResourceView ||  ( (MyUI)UI.getCurrent()).getLoggedInUser() == null && event.getNewView() instanceof HolidaysView ) {
                    Notification.show("Permission denied", Type.ERROR_MESSAGE);
                    return false;
				}
				
				return true;
			}
		});
        navigator.addView("", new LoginView());
        navigator.addView(RHVIEW,new HumainResourceView() );        
        navigator.addView(HOLIDAYVIEW, new HolidaysView());
        }
    
    public User getLoggedInUser(){
        return loggedInUser;
   }

   public void setLoggedInUser(User user){
        loggedInUser = user;
  }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}



