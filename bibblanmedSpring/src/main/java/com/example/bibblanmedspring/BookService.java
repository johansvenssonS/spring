package com.example.bibblanmedspring;

import com.example.bibblanmedspring.Book;
import com.example.bibblanmedspring.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    public final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository , BookMapper bookmapper, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookmapper;
        this.authorRepository = authorRepository;
    }


    public List<BookDto> getAllBooks(){
        return bookRepository.findAll().stream()
                .map(bookMapper::toDto)
                .toList();
    }
    //@Transactional(readOnly = true)
    public BookDto getById(Long id ){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bok med id" + id + "hittades ej!"));
        return bookMapper.toDto(book);
    }


    @Transactional
    public BookDto create(CreateBookDto dto){
        Author author = authorRepository.findById(dto.getAuthorId())
                .orElseThrow(() -> new RuntimeException(
                        "Författare mend id "+ dto.getAuthorId() + "hittades ej!"
                ));
        Book book = bookMapper.toEntity(dto, author);
        Book saved = bookRepository.save(book);
        return bookMapper.toDto(saved);
    }


}
