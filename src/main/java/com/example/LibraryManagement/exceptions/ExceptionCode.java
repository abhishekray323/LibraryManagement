package com.example.LibraryManagement.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor

@Getter

@ToString
public enum ExceptionCode {
    BOOK_ALREADY_EXISTS("LM_101", "Book already exists", HttpStatus.BAD_REQUEST);
    final String errorCode;
    final String errorMessage;
    final HttpStatus status;

}
