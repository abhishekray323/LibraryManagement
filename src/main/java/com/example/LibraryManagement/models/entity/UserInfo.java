package com.example.LibraryManagement.models.entity;

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


    @OneToMany(mappedBy = "usersInfo")
    List<Books> booksLended;

    @Column(unique = true)
    String emailId;

    Long phoneNumber;
}
