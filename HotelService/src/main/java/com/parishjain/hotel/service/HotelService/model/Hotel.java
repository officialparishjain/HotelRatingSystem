package com.parishjain.hotel.service.HotelService.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    @Id
    @Column(name = "Id")
    private String hotelId;

    @Column(name = "Name")
    private String hotelName;

    @Column(name = "Location")
    private String hotelLocation;

    @Column(name = "About")
    private String hotelAbout;



}
