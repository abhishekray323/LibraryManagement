package com.example.LibraryManagement.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor

@Getter

@ToString
public enum ExceptionCode {
    BOOK_NOT_FOUND("LM_101", "Book not found", HttpStatus.NOT_FOUND),
    BOOK_ALREADY_EXISTS("LM_102", "Book already exists", HttpStatus.BAD_REQUEST);
    final String errorCode;
    final String errorMessage;
    final HttpStatus status;

}
