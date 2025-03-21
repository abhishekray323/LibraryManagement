package com.example.LibraryManagement.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
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

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties(value="associatedBooks")
    Author associatedAuthor;

    @ManyToOne
    @JoinColumn
    UserInfo loanedTo;

    @Enumerated(value = EnumType.STRING)
    BookStatus bookStatus;

    @CreationTimestamp
    LocalDateTime creationTime;

    @UpdateTimestamp
    LocalDateTime updatedTime;

    @PrePersist
    void prePersist(){
        this.bookStatus = BookStatus.AVAILABLE;
    }

}
