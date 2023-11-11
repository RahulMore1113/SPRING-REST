package com.rahul.runner;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorServiceConsumingRunner_GettingJsonData implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		System.out.println("ActorServiceConsumingRunner_GettingJsonData.run()");

		RestTemplate template = new RestTemplate();
		String serviceUrl = "http://localhost:9090/providerapp/api/actor/find/{id}";

		Map<String, Object> map = new HashMap<>();
		map.put("id", 1);

		ResponseEntity<String> entity = template.getForEntity(serviceUrl, String.class, map);

		System.out.println("Response Body             :: " + entity.getBody());
		System.out.println("ResponseStatus Code Value :: " + entity.getStatusCodeValue());
		System.out.println("ResponseStatus Code       :: " + entity.getStatusCode());

		System.out.println("**********************************************************");

	}

}
