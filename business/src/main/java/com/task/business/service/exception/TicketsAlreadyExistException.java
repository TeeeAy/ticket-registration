package com.task.business.service.exception;

public class TicketsAlreadyExistException extends RuntimeException{
    public TicketsAlreadyExistException(String message) {
        super(message);
    }
}
