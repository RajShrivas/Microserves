package com.stark.hotel.service.HotelService.services;

import com.stark.hotel.service.HotelService.entity.Hotel;

import java.util.List;

public interface HotelService {


    Hotel saveHotelDetails(Hotel hotel);

    List<Hotel> getAllHotels();

    Hotel getHotelByID(long id);
}
