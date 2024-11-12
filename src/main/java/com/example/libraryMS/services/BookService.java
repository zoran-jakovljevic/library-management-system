package com.example.libraryMS.services;

import com.example.libraryMS.entity.Book;
import com.example.libraryMS.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAvailableBooks(){
        return bookRepository.findAvailableBooks();
    }

    public Book findBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
}
