package com.example.LibraryManagement.models.entity;

import com.example.LibraryManagement.models.entity.enums.BookStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String name;
    String isbn;

    Integer securityDeposit;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties(value="associatedBooks")
    @ToString.Exclude
    Author associatedAuthor;

    @ManyToOne
    @JsonIgnoreProperties(value="booksLent")
    @JoinColumn
    UserInfo loanedTo;

    @Enumerated(value = EnumType.STRING)
    BookStatus bookStatus;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties(value = "booksLent")
    Order mappedWithOrder;

    @CreationTimestamp
    LocalDateTime creationTime;

    @UpdateTimestamp
    LocalDateTime updatedTime;

    @PrePersist
    void prePersist(){
        this.bookStatus = BookStatus.AVAILABLE;
        this.securityDeposit = 250;
    }

}
