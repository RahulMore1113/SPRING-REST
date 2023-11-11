package com.rahul.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Actor {

	private Integer id;
	private String name;
	private Float age;
	private String type;

}
