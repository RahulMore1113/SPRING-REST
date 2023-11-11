package com.rahul.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.request.Passenger;
import com.rahul.response.Ticket;

@RestController
@RequestMapping("/api/ticket")
public class TicketBookingRestController {

	@PostMapping("/register")
	public ResponseEntity<Ticket> bookTicket(@RequestBody Passenger passenger) {

		Ticket ticket = new Ticket();
		ticket.setTicketId("LRAJ10");
		ticket.setFrom(passenger.getFrom());
		ticket.setTo(passenger.getTo());
		ticket.setJourneyDate(passenger.getJourneyDate());
		ticket.setPassengerName(passenger.getFirstName() + " " + passenger.getLastName());
		ticket.setTicketPrice(7823.0);
		ticket.setTicketStatus("Booked");
		ticket.setTrainNumber(passenger.getTrainNumber());

		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);

	}

}
