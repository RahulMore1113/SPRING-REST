package com.rahul.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahul.model.Tourist;

public interface ITouristRepo extends JpaRepository<Tourist, Integer> {

}
