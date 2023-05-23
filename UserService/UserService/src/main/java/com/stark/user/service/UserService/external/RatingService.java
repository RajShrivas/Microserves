package com.stark.user.service.UserService.external;

import com.stark.user.service.UserService.entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "RATING-SERVICE", url = "http://localhost:8083/")
public interface RatingService {
    @PostMapping("/rating/rate")
    Rating createRating(Rating rating);
}
