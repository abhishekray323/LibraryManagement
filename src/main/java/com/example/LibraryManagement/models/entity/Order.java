package com.example.LibraryManagement.models.entity;

import com.example.LibraryManagement.models.entity.enums.OrderStatus;
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
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Enumerated(value = EnumType.STRING)
    OrderStatus orderStatus;

    Long amountToBePayed;

    @ManyToOne
    @JoinColumn
    UserInfo createdBy;

    @OneToMany(mappedBy = "mappedWithOrder")
    List<Books> booksLent;

    @CreationTimestamp
    LocalDateTime creationTime;

    @UpdateTimestamp
    LocalDateTime updatedTime;

}
