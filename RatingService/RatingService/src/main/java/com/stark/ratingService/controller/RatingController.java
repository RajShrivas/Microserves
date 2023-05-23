package com.stark.ratingService.controller;

import com.stark.ratingService.entity.Rating;
import com.stark.ratingService.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/rate")
    public ResponseEntity<Rating> createUser(@RequestBody Rating rating) {
        Rating rate = ratingService.saveRatings(rating);
        return new ResponseEntity<>(rate, HttpStatus.CREATED);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable Long userId) {
        List<Rating> r = ratingService.getRatingByUserId(userId);
        return new ResponseEntity<>(r, HttpStatus.OK);
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable Long hotelId) {
        List<Rating> hotelRatingList = ratingService.getRatingByHotelId(hotelId);
        return new ResponseEntity<>(hotelRatingList, HttpStatus.OK);
    }


    @GetMapping()
    public ResponseEntity<List<Rating>> getAllUsers() {
        List<Rating> list = ratingService.getAllRatings();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
