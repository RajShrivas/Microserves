package com.stark.hotel.service.HotelService.repo;

import com.stark.hotel.service.HotelService.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<Hotel, Long> {
}
