package com.stark.hotel.service.HotelService.exception;

public class HotelException extends RuntimeException {

    public HotelException() {
        super("Resource not found!!!!!");
    }

    public HotelException(String message) {
        super(message);
    }
}
