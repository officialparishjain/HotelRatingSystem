package com.parishjain.rating.service;

import com.parishjain.rating.exception.ResourceNotFoundException;
import com.parishjain.rating.model.Rating;
import com.parishjain.rating.repo.RatingRepo;
import com.parishjain.rating.service.impl.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements RatingService {

    @Autowired
    RatingRepo ratingRepo;

    @Override
    public Rating createRating(Rating rating) {
        String id = UUID.randomUUID().toString();
        rating.setRatingId(id);
        return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepo.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepo.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepo.findByHotelId(hotelId);
    }


}
