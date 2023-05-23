package com.stark.user.service.UserService.external;

import com.stark.user.service.UserService.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "HOTEL-SERVICE", url = "http://localhost:8082/")
public interface HotelService {
    @GetMapping("hotel/{id}")
    Hotel getHotel(@PathVariable Long id);
}
