package com.rahul.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.response.Book;

@RestController
@RequestMapping("/api/book")
public class BookController {

	@GetMapping(value = "/getBook/{isbn}", produces = "application/json")
	public ResponseEntity<Book> getBook(@PathVariable String isbn) {

		Book book = new Book(isbn, "Sprng", 6783.0, "RodJhonson");

		Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getAllBooks())
				.withRel("allBooks");

		book.add(link);

		return new ResponseEntity<Book>(book, HttpStatus.OK);

	}

	@GetMapping("/allBooks")
	public List<Book> getAllBooks() {

		List<Book> bookList = new ArrayList<>();

		bookList.add(new Book("ISBN-111", "Spring", 672.0, "RedJhonson"));
		bookList.add(new Book("ISBN-222", "Hibernate", 842.0, "GavinKing"));
		bookList.add(new Book("ISBN-333", "Servlet", 671.0, "KeitySeirra"));

		return bookList;

	}

}
