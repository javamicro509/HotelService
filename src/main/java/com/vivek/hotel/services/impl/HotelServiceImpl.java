package com.vivek.hotel.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivek.hotel.entities.Hotel;
import com.vivek.hotel.exceptions.ResourceNotFoundException;
import com.vivek.hotel.repositories.HotelRepository;
import com.vivek.hotel.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel create(Hotel hotel) {
		String hotelId = UUID.randomUUID().toString();
		hotel.setId(hotelId);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotel(String id) {
		return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel with given Id not Found"));
	}

}
