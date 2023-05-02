package com.amigos.services;

import com.amigos.model.Book;
import com.amigos.model.dto.BookDTO;
import com.amigos.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    BookRepository bookRepository;

    BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<BookDTO> getAllBooks(){

        return bookRepository.findAll()
                .stream()
                .map(book -> new BookDTO(
                        book.getId(),
                        book.getBookName(),
                        book.getCreatedAt())).toList();

    }

    public List<BookDTO> getFindBookByName(String bookName){

        return bookRepository.findBookByName(bookName)
                .stream()
                .map(book -> new BookDTO(
                        book.getId(),
                        book.getBookName(),
                        book.getCreatedAt())).toList();

    }


}
