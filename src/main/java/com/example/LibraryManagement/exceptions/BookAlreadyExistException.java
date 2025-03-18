package com.example.LibraryManagement.exceptions;

import com.example.LibraryManagement.service.BooksService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter

public class BookAlreadyExistException extends RuntimeException{

    ExceptionCode exceptionCode;

    public BookAlreadyExistException(ExceptionCode exceptionCode){
        super(exceptionCode.errorMessage);
        this.exceptionCode = exceptionCode;
    }
}
