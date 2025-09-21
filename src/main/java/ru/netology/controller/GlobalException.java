package ru.netology.controller;

import jakarta.validation.UnexpectedTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.netology.exception.MyRepoException;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> catchResourceArgumentNotValidException(MethodArgumentNotValidException ex) {
        return new ResponseEntity<>("Ошибка валидации: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseEntity<Object> catchResourceUnexpectedTypeException(UnexpectedTypeException ex) {
        return new ResponseEntity<>("Ошибка валидации: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MyRepoException.class)
    public ResponseEntity<Object> catchResourceMyRepoException(MyRepoException ex) {
        return new ResponseEntity<>("Ошибка валидации: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}