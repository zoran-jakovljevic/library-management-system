package com.example.libraryMS.controller;

import com.example.libraryMS.entity.CheckedOutBook;
import com.example.libraryMS.entity.Member;
import com.example.libraryMS.entity.Book;
import com.example.libraryMS.services.BookService;
import com.example.libraryMS.services.CheckedOutBookService;
import com.example.libraryMS.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CheckedOutBookController {

    @Autowired
    private CheckedOutBookService checkedOutBookService;

    @PostMapping("/checkout")
    public ResponseEntity<String> checkoutBook(@RequestParam String memberJmbg, @RequestParam String bookIsbn) {

        boolean ok = checkedOutBookService.checkedOutBooks(memberJmbg, bookIsbn);

        if(ok){
            return ResponseEntity.ok("Successfully checked-out");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
        }

    }

    @GetMapping("/checkedoutbooks")
    public List<CheckedOutBook> getCheckedOutBooks() {
        return checkedOutBookService.getBooks();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntity(@PathVariable Integer id){
        boolean isDeleted = checkedOutBookService.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}

