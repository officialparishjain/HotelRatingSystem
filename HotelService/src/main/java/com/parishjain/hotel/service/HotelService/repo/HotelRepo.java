package com.parishjain.hotel.service.HotelService.repo;

import com.parishjain.hotel.service.HotelService.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepo extends JpaRepository<Hotel,String> {
}
