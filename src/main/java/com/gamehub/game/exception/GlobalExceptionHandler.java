package com.gamehub.game.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RAWGApiException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    private ErrorResponse entityDoesNotExistException(HttpServletRequest req, RAWGApiException ex) {
        ErrorResponse resource = new ErrorResponse(ex.getMessage());
        resource.setCode("404");
        return resource;
    }
}
