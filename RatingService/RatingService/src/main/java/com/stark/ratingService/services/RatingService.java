package com.stark.ratingService.services;

import com.stark.ratingService.entity.Rating;

import java.util.List;

public interface RatingService {

    Rating saveRatings(Rating rating);

    List<Rating> getAllRatings();

    List<Rating> getRatingByUserId(long id);

    List<Rating> getRatingByHotelId(long id);
}
