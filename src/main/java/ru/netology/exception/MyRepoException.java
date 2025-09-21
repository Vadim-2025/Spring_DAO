package ru.netology.exception;

public class MyRepoException extends RuntimeException {
    public MyRepoException(String msg) {
        super(msg);
    }
}