package com.rahul.service;

import java.util.List;

import com.rahul.model.Tourist;

public interface ITouristMgmtService {

	public String registerTourist(Tourist tourist);

	public List<Tourist> getAllTourist();

	public Tourist fetchTouristById(Integer id);

	public String updateTouristByDetails(Tourist tourist);

	public String updatetTouristById(Integer id, Float hikePercent);

	public String deleteTouristById(Integer id);

}
