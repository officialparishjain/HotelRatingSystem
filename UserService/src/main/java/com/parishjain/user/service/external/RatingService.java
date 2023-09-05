package com.parishjain.user.service.external;

import com.parishjain.user.service.model.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {


    // Post Rating  // For Just Understanding
    @PostMapping(value = "rating")
    public Rating createRating(Rating rating);



}
