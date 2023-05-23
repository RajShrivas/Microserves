package com.stark.user.service.UserService.exception;

public class UserExceptiion extends RuntimeException {

    public UserExceptiion() {
        super("Resource not found!!!!!");
    }

    public UserExceptiion(String message) {
        super(message);
    }
}
