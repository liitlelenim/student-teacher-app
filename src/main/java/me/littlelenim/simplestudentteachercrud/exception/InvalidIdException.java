package me.littlelenim.simplestudentteachercrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidIdException  extends RuntimeException{
    public InvalidIdException(String errorMessage) {
        super(errorMessage);
    }
}
