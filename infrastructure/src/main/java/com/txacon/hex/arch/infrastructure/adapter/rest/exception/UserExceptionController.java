package com.txacon.hex.arch.infrastructure.adapter.rest.exception;

import com.txacon.hex.arch.application.exceptions.DefaultInfException;
import com.txacon.hex.arch.application.exceptions.InvalidUserException;
import com.txacon.hex.arch.application.exceptions.UserNotFoundException;
import org.apache.catalina.connector.RequestFacade;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.ServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class UserExceptionController {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> userNotFoundExceptionHandler(UserNotFoundException exception, ServletRequest request){
        Map<String,Object> body = getStringObjectMap(exception, request);
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidUserException.class)
    public ResponseEntity<Object> userNotFoundExceptionHandler(InvalidUserException exception, ServletRequest request){
        Map<String, Object> body = getStringObjectMap(exception, request);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    private Map<String, Object> getStringObjectMap(DefaultInfException exception, ServletRequest request) {
        Map<String,Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message" , exception.getExceptionMessage());
        body.put("method" , ((RequestFacade) request).getMethod());
        body.put("endpoint",((RequestFacade) request).getRequestURI());
        return body;
    }
}
