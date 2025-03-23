package com.example.LibraryManagement.controller;

import com.example.LibraryManagement.models.entity.Books;
import com.example.LibraryManagement.models.request.CreateBookRequest;
import com.example.LibraryManagement.service.BooksService;
import com.example.LibraryManagement.service.CatalogueService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("/v1/books")
@Slf4j
public class BooksController {
    @Autowired
    CatalogueService catalogueService;

    @Autowired
    BooksService booksService;

    @PostMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Books> addBook(@RequestBody @Valid CreateBookRequest createBookRequest){
        return new ResponseEntity<>(catalogueService.addBookToCatalogue(createBookRequest), HttpStatus.CREATED);
    }

    @GetMapping(value="/book/isbn/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Books> getBooks(@PathVariable("id") String isbn){
        return new ResponseEntity<>(catalogueService.getBooks(isbn), HttpStatus.OK);
    }
}
