package com.stark.ratingService.exception;

public class RatingExceptiion extends RuntimeException {

    public RatingExceptiion() {
        super("Resource not found!!!!!");
    }

    public RatingExceptiion(String message) {
        super(message);
    }
}
