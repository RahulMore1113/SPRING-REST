package com.rahul.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.rahul.response.CurrencyResponse;

@Service
public class CurrencyService {

	private static final String REST_END_POINT = "http://localhost:9090/api/currency/getCurrencyExchangeCost/from/USD/to/INR";

	public void invokeRestApiSync(String from, String to) {

		WebClient webClient = WebClient.create();

		System.out.println("***Synchronus: Rest Call Started***");

		CurrencyResponse response = webClient.get().uri(REST_END_POINT, from, to).retrieve()
				.bodyToMono(CurrencyResponse.class).block();

		System.out.println(response);
		System.out.println("***Synchronus: Rest Call Ended***");

	}

	public void invokeRestApiAsync(String from, String to) {

		WebClient webClient = WebClient.create();

		System.out.println("***ASynchronus: Rest Call Started***");

		webClient.get().uri(REST_END_POINT, from, to).retrieve().bodyToMono(CurrencyResponse.class)
				.subscribe(CurrencyService::myResponse);

		System.out.println("***ASynchronus: Rest Call Ended***");

	}

	public static void myResponse(CurrencyResponse response) {

		System.out.println(response);

	}

}
