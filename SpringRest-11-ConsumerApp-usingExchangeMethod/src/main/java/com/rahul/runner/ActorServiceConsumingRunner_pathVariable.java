package com.rahul.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorServiceConsumingRunner_pathVariable implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		System.out.println("ActorServiceConsumingRunner_pathVariable.run()");

		RestTemplate template = new RestTemplate();
		String serviceUrl = "http://localhost:9090/providerapp/api/actor/wish/{id}/{name}";

		ResponseEntity<String> entity = template.exchange(serviceUrl, HttpMethod.GET, null, String.class, 1, "Rahul");

		System.out.println("Response Body             :: " + entity.getBody());
		System.out.println("ResponseStatus Code Value :: " + entity.getStatusCodeValue());
		System.out.println("ResponseStatus Code       :: " + entity.getStatusCode());

		System.out.println("**********************************************************");

	}

}
