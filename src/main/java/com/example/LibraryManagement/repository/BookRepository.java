package com.example.LibraryManagement.repository;

import com.example.LibraryManagement.models.entity.Books;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Books, String> {

    public Optional<Books> getBooksByIsbn(String isbn);

    public Page<Books> findByNameStartingWith(String nameStartsWith, PageRequest pageRequest);
}
