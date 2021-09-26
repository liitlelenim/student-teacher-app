package me.littlelenim.simplestudentteachercrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class InvalidIdException extends RuntimeException {
    public InvalidIdException(String errorMessage) {
        super(errorMessage);
    }
}
