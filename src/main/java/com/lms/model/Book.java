package com.lms.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Book {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column
    String title;

    @Column
    String author;

    @Column
    String description;

    @Column
    LocalDate publicationDate;

    @Column
    String publisher;

    @Column
    String category;

    @Column
    boolean availability;

    @Column
    String borrower;

    @Column
    LocalDate returnDate;

}
