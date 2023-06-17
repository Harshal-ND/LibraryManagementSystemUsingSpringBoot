package com.lms.librarymanagementsystem.model;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Book {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String title;

    @ManyToOne
    @JoinColumn(name="author_id")
    private Author author;

    @Column
    String publisher;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name="borrower_id")
    private User borrower;

    @Column
    LocalDate issueDate;

    @Column
    LocalDate returnDate;

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
        this.returnDate = issueDate.plusDays(7);
    }
    
    @Column
    Float fine;

}
