package com.example.LibraryManagement.service;

import com.example.LibraryManagement.models.entity.Books;
import com.example.LibraryManagement.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class BooksService {

    @Autowired
    BookRepository bookRepository;

    public Books saveOrUpdate(Books books){
        return bookRepository.save(books);
    }

    public Optional<Books> getBooksByIsbn(String isbn){
        return bookRepository.getBooksByIsbn(isbn);
    }

    public Page<Books> getBooksByNameStartsWith(String nameStartsWith, int pageNumber){
        PageRequest pageRequest = PageRequest.of(pageNumber, 3, Sort.by(Sort.Direction.DESC, "createAt"));
        return bookRepository.findByNameStartingWith(nameStartsWith, pageRequest);
    }
}
