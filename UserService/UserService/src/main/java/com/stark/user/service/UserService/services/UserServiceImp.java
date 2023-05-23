package com.stark.user.service.UserService.services;

import com.stark.user.service.UserService.entity.Hotel;
import com.stark.user.service.UserService.entity.Rating;
import com.stark.user.service.UserService.entity.User;
import com.stark.user.service.UserService.exception.UserExceptiion;
import com.stark.user.service.UserService.external.HotelService;
import com.stark.user.service.UserService.repo.UserRepo;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private final Logger logger = LoggerFactory.getLogger(UserServiceImp.class);

    @Override
    public User saveUsers(User user) {
        User u = null;
        if (user != null) {
            u = userRepo.save(user);
        }
        return u;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> usersList = userRepo.findAll();
        List<User> usersWithRatings = usersList.stream().peek(user -> {
            Rating[] rating = restTemplate.getForObject("http://RATING-SERVICE/rating/users/" + user.getId(), Rating[].class);
            assert rating != null;
            List<Rating> ratings = Arrays.stream(rating).toList();
            List<Rating> ratingList = ratings.stream().peek(rate -> {
                Hotel hotel = restTemplate.getForObject("http://HOTEL-SERVICE/hotel/" + rate.getHotelId(), Hotel.class);
                rate.setHotel(hotel);
            }).toList();
            user.setRatings(ratingList);
        }).toList();
        return usersWithRatings;
    }

    @Override
    public User getUserByID(Long id) {
        User user = userRepo.findById(id).orElseThrow(UserExceptiion::new);
        Rating[] rating = restTemplate.getForObject("http://RATING-SERVICE/rating/users/" + user.getId(), Rating[].class);

        assert rating != null;
        List<Rating> ratings = Arrays.stream(rating).toList();
        List<Rating> ratingList = ratings.stream().peek(rate -> {
            //Hotel hotel = restTemplate.getForObject("http://HOTEL-SERVICE/hotel/" + rate.getHotelId(), Hotel.class);
            try {
                Hotel hotel = hotelService.getHotel(rate.getHotelId());
                rate.setHotel(hotel);
            } catch (FeignException e) {
                if (e.status() == 302) {
                    String redirectedUrl = e.request().url();
                    System.out.println(redirectedUrl);
                }
            }


        }).toList();
        user.setRatings(ratingList);
        return user;
    }
}
