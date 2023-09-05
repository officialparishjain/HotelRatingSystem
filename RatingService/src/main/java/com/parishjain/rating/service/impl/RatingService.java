package com.parishjain.rating.service.impl;


import com.parishjain.rating.model.Rating;

import java.util.List;

public interface RatingService {


    // Create Rating
    Rating createRating(Rating rating);

    // Create Get all ratings
    List<Rating> getAllRatings();

    // Get Rating By User Id
    List<Rating> getRatingByUserId(String userId);

    // Get Rating By Hotel Id
    List<Rating> getRatingByHotelId(String hotelId);



}
