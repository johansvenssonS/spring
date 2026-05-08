package com.example.bibblanmedspring;

public class BookDto {

    private Long id;
    private String title;
    private String isbn;
    private int year;


    private boolean available;
    private String authorName;

    public BookDto(){}
    public BookDto(Long id, String title, String isbn, int year, boolean available, String authorName) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.year = year;
        this.available = available;
        this.authorName = authorName;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
