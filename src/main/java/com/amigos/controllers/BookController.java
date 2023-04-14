package com.amigos.controllers;

import com.amigos.model.Book;
import com.amigos.services.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app/v3")
public class BookController {

    BookService bookService;

    BookController(final BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/1")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
}
