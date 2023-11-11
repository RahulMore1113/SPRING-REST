package com.rahul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.rahul.service.ERailClientApp;

@SpringBootApplication
public class SpringRest15WebClientPostRequestApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringRest15WebClientPostRequestApplication.class, args);

		ERailClientApp app = context.getBean(ERailClientApp.class);

		app.invokeRestApi();
	}

}
