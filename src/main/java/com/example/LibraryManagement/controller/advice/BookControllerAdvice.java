package com.example.LibraryManagement.controller.advice;

import com.example.LibraryManagement.exceptions.BookAlreadyExistException;
import com.example.LibraryManagement.models.response.ErrorMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BookControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<ErrorMessage> catchBookAlreadyExistError(BookAlreadyExistException bookAlreadyExistException){
        return new ResponseEntity<ErrorMessage>(ErrorMessage.builder()
                .errorCode(bookAlreadyExistException.getExceptionCode().getErrorCode())
                .errorMessage((bookAlreadyExistException.getExceptionCode().getErrorMessage())).build(),
                bookAlreadyExistException.getExceptionCode().getStatus());
    }
}
