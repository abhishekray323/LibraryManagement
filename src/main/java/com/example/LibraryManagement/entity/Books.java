package com.example.LibraryManagement.entity;

import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;
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

    @OneToMany
    @JoinColumn
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
