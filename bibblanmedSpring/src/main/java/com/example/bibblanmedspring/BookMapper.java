package com.example.bibblanmedspring;


import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public BookDto toDto(Book book) {
        String authorName = book.getAuthor() != null
                ? book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName()
                : "Okänd";

        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getIsbn(),
                book.getYear(),
                book.getCopiesAvailable() > 0,  // AffärsLogik i mappern
                authorName
        );

    }
        public Book toEntity(CreateBookDto dto, Author author){
            return new Book(
                    dto.getTitle(),dto.getIsbn(), dto.getYear(),
                    dto.getCopiesTotal(), dto.getCopiesTotal(), author);
        }


}
