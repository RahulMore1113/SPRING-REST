package com.rahul.service;

import java.util.List;

import com.rahul.model.Tourist;

public interface ITouristMgmtService {

	public String registerTourist(Tourist tourist);

	public List<Tourist> getAllTourists();

	public Tourist fetchTouristById(Integer id);

	public String updateTouristByDetails(Tourist tourist);

	public String updateTouristById(Integer id, Double hikePercent);

	public String deleteTouristById(Integer id);

}
