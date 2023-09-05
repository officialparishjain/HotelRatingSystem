package com.parishjain.user.service.external;

import com.parishjain.user.service.model.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

    @GetMapping(value = "/hotels/{hotelId}")
    public Hotel getHotel(@PathVariable String hotelId);
}
