package com.example.LibraryManagement.service;

import com.example.LibraryManagement.models.entity.Author;
import com.example.LibraryManagement.repository.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public void saveOrUpdate(Author author ){
        authorRepository.save(author);
    }

    public Optional<Author> getAuthorByemailId(String isbn){
        return authorRepository.getAuthorByemailId(isbn);
    }
}
