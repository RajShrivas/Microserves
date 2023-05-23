package com.stark.user.service.UserService;

import com.stark.user.service.UserService.entity.Rating;
import com.stark.user.service.UserService.external.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

    @Autowired
    RatingService ratingService;

    @Test
    void contextLoads() {
    }

    @Test
    void createRating() {
        Rating rating = Rating.builder().ratingId(4).userId(2).rating(5).hotelId(2).feedback("Great taste and a great place to eat you will definitely enjoy your dinner").build();
        Rating savedRating = ratingService.createRating(rating);
        System.out.println(savedRating);
        System.out.printf("new rating created");
    }

}
