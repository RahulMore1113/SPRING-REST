package com.rahul.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

	private Integer pid;
	private String pname;
	private Double price;

}
