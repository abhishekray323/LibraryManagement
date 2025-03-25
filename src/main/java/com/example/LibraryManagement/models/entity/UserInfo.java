package com.example.LibraryManagement.models.entity;

import com.example.LibraryManagement.models.entity.enums.UserStatus;
import com.example.LibraryManagement.models.entity.enums.UserType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(indexes = {@Index(name="UNIQUE_EMAIL", columnList = "emailId", unique = true)})

public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String name;

    @Enumerated(value = EnumType.STRING)
    UserType userType;

    @Enumerated(value = EnumType.STRING)
    UserStatus userStatus;

    @OneToMany(mappedBy = "createdBy")
    List<Order> ordersCreated;

    @OneToMany(mappedBy = "loanedTo")
    List<Books> booksLent;

    @PrePersist
    public void prePersist(){
        this.userStatus = UserStatus.ACTIVE;
    }

}
