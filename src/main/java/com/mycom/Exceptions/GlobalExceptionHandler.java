package com.mycom.Exceptions;

import java.util.HashMap;
import java.util.Map;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex) {
    Map<String, String> resp = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String message = error.getDefaultMessage();
      resp.put(fieldName, message);
    });
    return new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<Map<String, String>> handleConstraintViolationException(ConstraintViolationException ex) {
    Map<String, String> resp = new HashMap<>();
    String[] err = ex.getCause().toString().split(":");
    resp.put(err[0], err[1]);
    return new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity<Map<String, String>> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
    Map<String, String> resp = new HashMap<>();
    String[] err = ex.getCause().toString().split(":");
    resp.put(err[0], err[1]);
    return new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Map<String, String>> handleException(Exception ex) {
    Map<String, String> resp = new HashMap<>();
    resp.put(ex.getClass().toString(), ex.getMessage());
    return new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);
  }

}
