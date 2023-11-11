package com.rahul.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.rahul.request.Passenger;
import com.rahul.response.Ticket;

@Service
public class ERailClientApp {

	private static final String REST_END_URI = "http://localhost:9090/api/ticket/register";

	public void invokeRestApi() {

		WebClient webClient = WebClient.create();

		Passenger passenger = new Passenger();
		passenger.setFirstName("Rahul");
		passenger.setLastName("More");
		passenger.setFrom("PUNE");
		passenger.setTo("BANGLORE");
		passenger.setJourneyDate("07-FEB-2024");
		passenger.setTrainNumber("1113");

		Ticket response = webClient.post().uri(REST_END_URI).accept(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromValue(passenger)).retrieve().bodyToMono(Ticket.class).block();

		System.out.println(response);

	}

}
