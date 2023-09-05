package com.parishjain.hotel.service.HotelService.controller;

import com.parishjain.hotel.service.HotelService.model.Hotel;
import com.parishjain.hotel.service.HotelService.service.impl.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    HotelService hotelService;


    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createHotel(hotel));
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotelById(hotelId));
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels(){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAllHotels());
    }
}
