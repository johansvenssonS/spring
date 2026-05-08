package com.example.bibblanmedspring;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class CreateBookDto {
    @NotBlank(message = "Titel får inte vara tom")
    @Size(max = 255, message = "Titel får inte vara längre än 255 tecken")
    private String title;

    @NotBlank(message = "ISBN får inte vara tomt")
    private String isbn;

    @Positive(message = "År måste vara ett positivt tal")
    private int year;

    @Positive(message = "Antal exemplar måste vara minst 1")
    private int copiesTotal;

    @NotNull(message = "Författar-id måste anges")
    private Long authorId;

    public CreateBookDto() {}

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public int getCopiesTotal() { return copiesTotal; }
    public void setCopiesTotal(int copiesTotal) { this.copiesTotal = copiesTotal; }
    public Long getAuthorId() { return authorId; }
    public void setAuthorId(Long authorId) { this.authorId = authorId; }
}
