package com.example.LibraryManagement.controller;

import com.example.LibraryManagement.models.request.CreateBookRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@RequestMapping("/v1/books")
@Slf4j
public class BooksController {

    @PostMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    void addBook(@RequestBody @Valid CreateBookRequest createBookRequest){

    }
}
