package com.example.LibraryManagement.repository;

import com.example.LibraryManagement.models.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, String> {
    Optional<Author> getAuthorByemailId(String emailId);
}
