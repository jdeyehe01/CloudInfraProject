package com.esgi.fr.CloudProject.Controller;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RequestHttp {
	
	public RequestHttp() {
		Client client = ClientBuilder.newClient();
    	WebTarget webTarget = client.target("https://reqres.in/api/users/2");
    	Invocation.Builder incationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
    	Response response = incationBuilder.get();
    	String res = response.readEntity(String.class);
	}
	

}
