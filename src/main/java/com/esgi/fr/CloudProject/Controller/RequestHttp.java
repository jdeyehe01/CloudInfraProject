package com.esgi.fr.CloudProject.Controller;

import javax.ws.rs.client.Client;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RequestHttp {

	private final static String BASE_URL = "https://console.jumpcloud.com/api/";
	private final static String API_KEY = "fa28024f6d819b0e24bd625388fe01712b39ca25";  

	public static String getResponse(String endPoint) {
		Response response = getInvocation(endPoint).get();
		String res = response.readEntity(String.class);
		return res;
	}
	
	public static String postResponse(String endPoint, String json) {
		Response response = getInvocation(endPoint).post(Entity.json(json));
		String res = response.readEntity(String.class);
		return res;
	}

	private static Builder getInvocation(String endPoint) {
		String url = BASE_URL+endPoint;
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(url);				
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON).header("x-api-key", API_KEY);
		return invocationBuilder;
	}


}


