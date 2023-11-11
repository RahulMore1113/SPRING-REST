package com.rahul;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rahul.model.Product;

public class TestApp {

	public static void main(String[] args) {

		try {
			ObjectMapper mapper = new ObjectMapper();
			Product product = new Product();
			product = getObjectData(product);
			System.out.println("Data in Java Format :: " + product);

			String jsonData = mapper.writeValueAsString(product);
			System.out.println("Data in the JSON Format :: " + jsonData);

			mapper.writeValue(new File("data/product-list.json"), product);
			System.out.println("Wrote the data to the JSON file");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Product getObjectData(Product product) {

		product.setPid(10);
		product.setPname("fossil");
		product.setPrice(3429.4);

		return product;

	}

}
