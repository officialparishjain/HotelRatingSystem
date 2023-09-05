package com.parishjain.rating.repo;

import com.parishjain.rating.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingRepo extends JpaRepository<Rating,String> {

    List<Rating> findByUserId(String userId);

    List<Rating> findByHotelId(String hotelId);
}
