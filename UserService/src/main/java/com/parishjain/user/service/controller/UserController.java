package com.parishjain.user.service.controller;

import com.parishjain.user.service.model.User;
import com.parishjain.user.service.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping
    public  ResponseEntity<List<User>> getAllUser(){
        List<User> users = userService.getAllUser();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    int retryCount = 1;


    @GetMapping("/{userId}")
//    Here we defining the breaker  name and which method we have to called
//    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallBack")
//    @Retry(name = "ratingHotelService",fallbackMethod = "ratingHotelFallBack")
    @RateLimiter(name = "userRateLimiter",fallbackMethod = "ratingHotelFallBack")
    public ResponseEntity<User> getUserById(@PathVariable String userId){
//        logger.info("Retry Count: {}",retryCount);
//        retryCount++;
        User user = userService.getUserById(userId);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }


    // Creating Fall Back Method for circuit breaker
    // Return Type should be same
    public ResponseEntity<User> ratingHotelFallBack(String userId, Exception ex){
//        logger.info("Fall back is Executed because service is down , " + ex.getMessage());
        User user = User.builder().

                userEmail("dummy@gmail.com").
                userName("Dummy User").
                about("User is created because some service is down")
                .userId("141312")
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

}
