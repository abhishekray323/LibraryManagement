package com.example.LibraryManagement.repository;

import com.example.LibraryManagement.models.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Books, String> {
}
