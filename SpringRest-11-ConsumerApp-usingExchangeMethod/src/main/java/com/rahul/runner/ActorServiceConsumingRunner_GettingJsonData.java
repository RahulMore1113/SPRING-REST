package com.rahul.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.rahul.model.Actor;

@Component
public class ActorServiceConsumingRunner_GettingJsonData implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		System.out.println("ActorServiceConsumingRunner_GettingJsonData.run()");

		RestTemplate template = new RestTemplate();
		String serviceUrl = "http://localhost:9090/providerapp/api/actor/find/{id}";

		ResponseEntity<Actor> entity = template.exchange(serviceUrl, HttpMethod.GET, null, Actor.class, 1);

		System.out.println("Response Body             :: " + entity.getBody());
		System.out.println("ResponseStatus Code Value :: " + entity.getStatusCodeValue());
		System.out.println("ResponseStatus Code       :: " + entity.getStatusCode());

		System.out.println("**********************************************************");

	}

}
