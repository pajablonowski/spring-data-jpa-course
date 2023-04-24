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
        return DTOService.mapBookListIntoBookDTOList(bookRepository.findAll());
    }

    public List<BookDTO> getFindBookByName(String bookName){
        return DTOService.mapBookListIntoBookDTOList(bookRepository.findBookByName(bookName));
    }


}
