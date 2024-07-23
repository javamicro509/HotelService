package com.vivek.hotel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.hotel.entities.Hotel;
import com.vivek.hotel.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		Hotel hotel1 = hotelService.create(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getHotel(@PathVariable String id){
		Hotel hotel1 = hotelService.getHotel(id);
		return ResponseEntity.status(HttpStatus.OK).body(hotel1);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotel(){
		List<Hotel> hotels = hotelService.getAllHotel();
		return ResponseEntity.status(HttpStatus.OK).body(hotels);
		
	}
	
	
	
	

}
