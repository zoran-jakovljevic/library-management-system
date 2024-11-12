package com.example.libraryMS.controller;

import com.example.libraryMS.entity.Book;
import com.example.libraryMS.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;


    @PostMapping("/addnewbook")
    public ResponseEntity<String> addNewBook(@RequestBody Book book) {
        try {
            bookService.saveBook(book);
            return ResponseEntity.status(HttpStatus.CREATED).body("Book added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving book: " + e.getMessage());
        }
    }

}
