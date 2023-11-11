package com.rahul;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rahul.model.Customer;

public class TestApp {
	public static void main(String[] args) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Customer customer = mapper.readValue(new File("data/simple-full.json"), Customer.class);
			System.out.println(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
