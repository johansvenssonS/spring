package com.example.bibblanmedspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping()
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;
    private String htmlString1;
    private String htmlString2;
    private String content;
    private String content1;
    private String div;
    private String divA;
    private String divE;
    private String divAE;
    private String style;

    BookController(BookService b, AuthorService authorService){
        this.bookService = b;
        this.authorService = authorService;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks(){

        return bookService.getAllBooks();
    }
    @GetMapping("/test")
    public String getHtml(){
        List <Book> allBooks = bookService.getAllBooks();
        List <Author> allAuthors = authorService.getAllAuthors();

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
        for (Book b: allBooks){
            htmlString1 += counter+". " + b.getTitle() + " av: " + b.getAuthor().getFirstName() + " " + b.getAuthor().getLastName() + "<br>";
            counter++;
        }
        htmlString1 += "</books>";
        content += htmlString1;
        div += content;



        content1 = "<rubrik>Alla Författare </rubrik>"+ "<br>";
        htmlString2 += "<authors>";
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
