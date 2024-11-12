package com.example.libraryMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.libraryMS.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    Book findByIsbn(String isbn);

    @Query("SELECT b FROM Book b WHERE b.isbn NOT IN (SELECT c.book.isbn FROM CheckedOutBook c)")
    List<Book> findAvailableBooks();
}
