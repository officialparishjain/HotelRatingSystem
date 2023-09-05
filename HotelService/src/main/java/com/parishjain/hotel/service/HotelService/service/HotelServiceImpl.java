package com.parishjain.hotel.service.HotelService.service;

import com.parishjain.hotel.service.HotelService.exceptions.ResourceNotFoundException;
import com.parishjain.hotel.service.HotelService.model.Hotel;
import com.parishjain.hotel.service.HotelService.repo.HotelRepo;
import com.parishjain.hotel.service.HotelService.service.impl.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepo hotelRepo;

    @Override
    public Hotel createHotel(Hotel hotel) {
        String id = UUID.randomUUID().toString();
        hotel.setHotelId(id);
        return hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepo.findAll();
    }

    @Override
    public Hotel getHotelById(String id) {
        return hotelRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel with given Id not found"));
    }
}
