package com.rahul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.rahul.service.CurrencyService;

@SpringBootApplication
public class SpringRest13WebClientGetRequestApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringRest13WebClientGetRequestApplication.class, args);

		CurrencyService service = context.getBean(CurrencyService.class);

		String from = "USD";
		String to = "INR";
		service.invokeRestApiSync(from, to);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		service.invokeRestApiAsync(from, to);
	}

}
