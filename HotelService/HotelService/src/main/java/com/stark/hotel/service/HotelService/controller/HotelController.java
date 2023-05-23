package com.stark.hotel.service.HotelService.controller;

import com.stark.hotel.service.HotelService.entity.Hotel;
import com.stark.hotel.service.HotelService.services.HotelServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelServiceImp hotelService;

    @PostMapping("/register-hotel")
    public ResponseEntity<Hotel> createUser(@RequestBody Hotel hotel) {
        Hotel u = hotelService.saveHotelDetails(hotel);
        return new ResponseEntity<>(u, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getUserById(@PathVariable Long id) {
        Hotel u = hotelService.getHotelByID(id);
        return new ResponseEntity<>(u, HttpStatus.FOUND);
    }

    @GetMapping("/")
    public ResponseEntity<List<Hotel>> getAllUsers() {
        List<Hotel> userList = hotelService.getAllHotels();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }
}
