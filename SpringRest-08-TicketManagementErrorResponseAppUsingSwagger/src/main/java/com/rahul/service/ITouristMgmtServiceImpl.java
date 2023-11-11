package com.rahul.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.dao.ITouristRepo;
import com.rahul.exception.TouristNotFountException;
import com.rahul.model.Tourist;

@Service
public class ITouristMgmtServiceImpl implements ITouristMgmtService {

	@Autowired
	private ITouristRepo repo;

	@Override
	public String registerTourist(Tourist tourist) {

		return "Tourist registered with the ticket id :: " + repo.save(tourist).getTid();

	}

	@Override
	public List<Tourist> getAllTourists() {

		List<Tourist> list = repo.findAll();

		list.sort((t1, t2) -> t1.getTid().compareTo(t2.getTid()));

		return list;

	}

	@Override
	public Tourist fetchTouristById(Integer id) {

		return repo.findById(id).orElseThrow(() -> new TouristNotFountException("Tourist not found for id :: " + id));

	}

	@Override
	public String updateTouristByDetails(Tourist tourist) {

		Optional<Tourist> optional = repo.findById(tourist.getTid());

		if (optional.isPresent()) {
			repo.save(tourist);
			return "Tourist with id :: " + tourist.getTid() + " updated";
		} else
			throw new TouristNotFountException(
					"Tourist with the id :: " + tourist.getTid() + " is not found for updation");

	}

	@Override
	public String updateTouristById(Integer id, Double hikePercent) {

		Optional<Tourist> optional = repo.findById(id);

		if (optional.isPresent()) {
			Tourist tourist = optional.get();
			tourist.setBudget(tourist.getBudget() + (tourist.getBudget() * (hikePercent / 100)));
			repo.save(tourist);
			return "Tourist Budget is updated for the id :: " + id;
		} else
			throw new TouristNotFountException("Tourist is not found for the id :: " + id);

	}

	@Override
	public String deleteTouristById(Integer id) {

		Optional<Tourist> optional = repo.findById(id);

		if (optional.isPresent()) {
			repo.delete(optional.get());
			return "Tourist with id :: " + id + " deleted";
		} else
			throw new TouristNotFountException("Tourist not found for id :: " + id);

	}

}
