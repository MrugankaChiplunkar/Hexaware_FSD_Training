package com.hexaware.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @Column(nullable = false, unique = true)
    private String isbn;

    private String title;
    private String author;
    private int publicationYear;
}
