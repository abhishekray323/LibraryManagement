package com.example.LibraryManagement.service;

import com.example.LibraryManagement.models.entity.Books;
import com.example.LibraryManagement.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;

@Service
@Slf4j
public class BooksService {

    @Autowired
    BookRepository bookRepository;

    public Books saveOrUpdate(Books books){
        return bookRepository.save(books);
    }
}
