package com.parishjain.user.service.service.impl;

import com.parishjain.user.service.exceptions.ResourceNotFoundException;
import com.parishjain.user.service.external.HotelService;
import com.parishjain.user.service.model.Hotel;
import com.parishjain.user.service.model.Rating;
import com.parishjain.user.service.model.User;
import com.parishjain.user.service.repository.UserRepo;
import com.parishjain.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;


//    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {

        String id = UUID.randomUUID().toString();
        user.setUserId(id);
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(String id) {
        User user =  userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User given Id is not found on server !! : " + id));
        // Fetching rating of above user by Rating Service
        Rating[] ratingsForUser = restTemplate.getForObject("http://RATING-SERVICE/rating/users/"+user.getUserId(), Rating[].class);
//        logger.info("{}", (Object) ratingsForUser);

        List<Rating> ratings = Arrays.stream(ratingsForUser).toList();

        // Fetching the hotel details from Hotel Service
        List<Rating> ratingList = new ArrayList<>();

        for(Rating rating : ratings) {

//             Here we are using rest Template
//                ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
//            Hotel hotel = forEntity.getBody();

//            Now we are using feign client
//            This is a Best Approach

                Hotel hotel = hotelService.getHotel(rating.getHotelId());
                // Set the hotel to Rating
                rating.setHotel(hotel);
                ratingList.add(rating);
        }
        user.setRatings(ratingList);
        return user;
    }
}
