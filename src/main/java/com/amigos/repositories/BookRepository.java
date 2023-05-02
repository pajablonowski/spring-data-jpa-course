package com.amigos.repositories;

import com.amigos.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b from Book b where b.bookName = ?1")
    List<Book> findBookByName(String bookName);


}
