package com.te.car.service;

import java.util.List;

import com.te.car.dto.CarDetails;

public interface CarService {

	
	public CarDetails addData(CarDetails details);

	public CarDetails getData(int id); 
	
	public List<CarDetails> getAll();
}
