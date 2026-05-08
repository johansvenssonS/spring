package com.example.bibblanmedspring;

import jakarta.persistence.*;

@Entity
@Table(name="books")
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;

    private String isbn;
    private int year;
    private int copiesTotal;
    private int copiesAvailable;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private Author author;

    public Book() {
    }

    public Book(String title, String isbn, int year, int copiesTotal, int copiesAvailable, Author author) {
        this.title = title;
        this.isbn = isbn;
        this.year = year;
        this.copiesTotal = copiesTotal;
        this.copiesAvailable = copiesAvailable;
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }

    public int getCopiesTotal() {
        return copiesTotal;
    }

    public void setCopiesTotal(int copiesTotal) {
        this.copiesTotal = copiesTotal;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}