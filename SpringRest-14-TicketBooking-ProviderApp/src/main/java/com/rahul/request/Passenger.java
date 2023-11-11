package com.rahul.request;

import lombok.Data;

@Data
public class Passenger {

	private String firstName;
	private String lastName;
	private String from;
	private String to;
	private String journeyDate;
	private String trainNumber;

}
