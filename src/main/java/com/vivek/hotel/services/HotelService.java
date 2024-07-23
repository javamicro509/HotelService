package com.vivek.hotel.services;

import java.util.List;

import com.vivek.hotel.entities.Hotel;
import com.vivek.hotel.repositories.HotelRepository;

public interface HotelService {

	Hotel create(Hotel hotel);
	
	List<Hotel> getAllHotel();
	
	Hotel getHotel(String id);
	
	//Update
	//Delete
}
