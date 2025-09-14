package ru.netology.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> catchResourceArgumentNotValidException(MethodArgumentNotValidException ex) {
        return new ResponseEntity<>("Ошибка валидации: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}