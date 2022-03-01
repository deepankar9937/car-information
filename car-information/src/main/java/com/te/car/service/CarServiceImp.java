package com.te.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.car.dao.CarDao;
import com.te.car.dto.CarDetails;

@Service
public class CarServiceImp implements CarService{
	
	@Autowired
	private CarDao carDao;

	@Override
	public CarDetails addData(CarDetails details) {
		return carDao.save(details);
				
	}

	@Override
	public CarDetails getData(int id) {
		return carDao.findByCarId(id);
	}

	@Override
	public List<CarDetails> getAll() {
		return (List<CarDetails>) carDao.findAll();
	}

}
