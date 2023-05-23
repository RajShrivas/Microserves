package com.stark.user.service.UserService.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Rating {

    private long ratingId;
    private long userId;
    private long hotelId;
    private long rating;
    private String feedback;
    private Hotel hotel;

}
