package com.example.bibblanmedspring;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorService {

    public final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository r ){
        this.authorRepository = r;
    }

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }
}
