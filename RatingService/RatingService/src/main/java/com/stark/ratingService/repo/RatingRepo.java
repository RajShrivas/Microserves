package com.stark.ratingService.repo;

import com.stark.ratingService.entity.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepo extends MongoRepository<Rating, Long> {

    List<Rating> findByUserId(long id);

    List<Rating> findByHotelId(long id);
}
