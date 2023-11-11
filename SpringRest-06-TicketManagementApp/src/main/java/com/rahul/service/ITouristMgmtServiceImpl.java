package com.rahul.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.dao.ITouristRepo;
import com.rahul.exception.TouristNotFoundException;
import com.rahul.model.Tourist;

@Service
public class ITouristMgmtServiceImpl implements ITouristMgmtService {

	@Autowired
	private ITouristRepo repo;

	@Override
	public String registerTourist(Tourist tourist) {

		Integer tid = repo.save(tourist).getTid();

		return "Tourist is register having the ticket id :: " + tid;

	}

	@Override
	public List<Tourist> getAllTourist() {

		List<Tourist> list = repo.findAll();

		list.sort((t1, t2) -> t1.getTid().compareTo(t2.getTid()));

		return list;

	}

	@Override
	public Tourist fetchTouristById(Integer id) {

//		Optional<Tourist> optional = repo.findById(id);
//
//		if (optional.isPresent())
//			return optional.get();
//		else
//			throw new TouristNotFoundException("Tourist is not found for the id :: " + id);

		return repo.findById(id)
				.orElseThrow(() -> new TouristNotFoundException("Tourist is not found for id :: " + id));

	}

	@Override
	public String updateTouristByDetails(Tourist tourist) {

		Optional<Tourist> optional = repo.findById(tourist.getTid());

		if (optional.isPresent())
			return "Tourist with id :: " + repo.save(tourist).getTid() + " updated";
		else
			throw new TouristNotFoundException(
					"Tourist with the id :: " + tourist.getTid() + " is not available for updation");

	}

	@Override
	public String updatetTouristById(Integer id, Float hikePercent) {

		Optional<Tourist> optional = repo.findById(id);

		if (optional.isPresent()) {
			Tourist tourist = optional.get();
			tourist.setBudget(tourist.getBudget() + (tourist.getBudget() * (hikePercent / 100)));
			repo.save(tourist);
			return "Tourist budget is updated for the id :: " + tourist.getTid();
		} else
			throw new TouristNotFoundException("Tourist is not found for the id :: " + id);

	}

	@Override
	public String deleteTouristById(Integer id) {

		Optional<Tourist> optional = repo.findById(id);
		if (optional.isPresent()) {
			repo.delete(optional.get());
			return "Tourist with id :: " + id + " deleted";
		} else
			throw new TouristNotFoundException("Tourist is not found for the id :: " + id);

	}

}
