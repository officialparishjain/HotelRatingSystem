package com.parishjain.hotel.service.HotelService.service.impl;

import com.parishjain.hotel.service.HotelService.model.Hotel;

import java.util.List;

public interface HotelService {


    // Create the hotel
    Hotel createHotel(Hotel hotel);

    // Get All Hotels
    List<Hotel> getAllHotels();

    // Get Hotel By Id
    Hotel getHotelById(String id);
}
