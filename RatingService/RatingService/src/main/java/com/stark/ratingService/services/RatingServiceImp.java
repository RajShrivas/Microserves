package com.stark.ratingService.services;

import com.stark.ratingService.entity.Rating;
import com.stark.ratingService.repo.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RatingServiceImp implements RatingService {
    @Autowired
    private RatingRepo ratingRepo;

    @Override
    public Rating saveRatings(Rating rating) {
        Rating r = null;
        if (rating != null) {
            r = ratingRepo.save(rating);
        }
        return r;
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepo.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(long id) {
        return ratingRepo.findByUserId(id);
    }

    @Override
    public List<Rating> getRatingByHotelId(long id) {
        return ratingRepo.findByHotelId(id);
    }


}
