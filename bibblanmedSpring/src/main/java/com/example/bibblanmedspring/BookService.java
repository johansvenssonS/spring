package com.example.bibblanmedspring;

import com.example.bibblanmedspring.Book;
import com.example.bibblanmedspring.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    public final BookRepository bookRepository;


    public BookService(BookRepository r){
        this.bookRepository = r;
    }


    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }


}
