package com.stark.hotel.service.HotelService.services;

import com.stark.hotel.service.HotelService.entity.Hotel;
import com.stark.hotel.service.HotelService.exception.HotelException;
import com.stark.hotel.service.HotelService.repo.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImp implements HotelService {
    @Autowired
    private HotelRepo hotelRepo;

    @Override
    public Hotel saveHotelDetails(Hotel hotel) {
        Hotel h = null;
        if (hotel != null) {
            h = hotelRepo.save(hotel);
        }
        return h;
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepo.findAll();
    }

    @Override
    public Hotel getHotelByID(long id) {
        return hotelRepo.findById(id).orElseThrow(HotelException::new);
    }
}
