package com.rahul.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorServiceConsumingRunner_PostingJsonData implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		System.out.println("ActorServiceConsumingRunner_PostingJsonData.run()");

		RestTemplate template = new RestTemplate();
		String serviceUrl = "http://localhost:9090/providerapp/api/actor/register";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		String json_body = "{\r\n" + "    \"id\": 21,\r\n" + "    \"name\": \"Krishna\",\r\n" + "    \"age\": 23,\r\n"
				+ "    \"type\": \"God\"\r\n" + "}";

		HttpEntity<String> request = new HttpEntity<>(json_body, headers);

		ResponseEntity<String> entity = template.exchange(serviceUrl, HttpMethod.POST, request, String.class);

		System.out.println("Response Body             :: " + entity.getBody());
		System.out.println("ResponseStatus Code Value :: " + entity.getStatusCodeValue());
		System.out.println("ResponseStatus Code       :: " + entity.getStatusCode());

		System.out.println("**********************************************************");

	}

}
