package com.example.LibraryManagement.repository;

import com.example.LibraryManagement.models.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, String> {
}
