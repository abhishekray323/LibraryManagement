package com.example.LibraryManagement.models.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(indexes = {@Index(name="UNIQUE_EMAIL", columnList = "emailId", unique = true)})

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String name;

    @OneToMany(mappedBy = "associatedAuthor")
    List<Books> associatedBooks;

    @Column(nullable = false)
    String emailId;

    @CreationTimestamp
    LocalDateTime creationTime;

    @UpdateTimestamp
    LocalDateTime updatedTime;

}
