package com.example.bibblanmedspring;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping()
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    BookController(BookService b, AuthorService authorService){
        this.bookService = b;
        this.authorService = authorService;
    }

    @GetMapping("/books")
    public ResponseEntity <List<BookDto>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<BookDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(bookService.getById(id));
    }

    @PostMapping("/books")
    public ResponseEntity<BookDto> create(@Valid @RequestBody CreateBookDto dto){
        BookDto created = bookService.create(dto);
        URI location = URI.create("/books/" + created.getId());
        return ResponseEntity.created(location).body(created);

        //return ResponseEntity.status(201).body(created);
    }


    @GetMapping("/test")
    public String getHtml(){
        String htmlString1= "";
        String htmlString2 = "";
        String content = "";
        String content1= "";
        String div = "";
        String style = "";
        String divE = "";
        List <BookDto> allBooks = bookService.getAllBooks();
        List <Author> allAuthors = authorService.getAllAuthors();
        System.out.println("Authors count: " + allAuthors.size());
        System.out.println("Books count: " + allBooks.size());

        style = "<style> " +
                "container{display:flex; align-items:center; justify-content: center; background-color:black; flex-direction:column;}" +
                "rubrik{color:red; font-size: 36px; display: flex; }"+
                "books{color:white; font-size: 18px; display: flex;  border: 3px solid yellow; align-items:center; padding: 5px;}"+
                "authors{color:white; font-size: 18px; display: flex;  border: 3px solid yellow; align-items:center; padding: 5px;}"+
                "</style>";
        div = "<container>";
        divE = "</container>";
        content = "<rubrik>Alla böcker </rubrik>"+ "<br>";
        htmlString1 = "<books>";
        int counter = 1;
        for (BookDto b: allBooks){
            htmlString1 += counter+". " + b.getTitle() + " av: " + b.getAuthorName() + "<br>";
            counter++;
        }
        htmlString1 += "</books>";
        content += htmlString1;
        div += content;



        content1 = "<rubrik>Alla Författare </rubrik>"+ "<br>";
        htmlString2 = "<authors>";
        int counterA = 1;
        for (Author a: allAuthors){
            htmlString2 += counterA+". " + a.getBorn() + " av: " + a.getCreatedAt() + " " + a.getUpdatedAt() + "<br>";
            counterA++;
        }
        htmlString2 += "</authors>";
        content1 += htmlString2;

        div += content1;

        style += div;
        return style;
    }

}
