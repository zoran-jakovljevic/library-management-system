package com.example.libraryMS.controller;

import com.example.libraryMS.entity.Book;
import com.example.libraryMS.entity.CheckedOutBook;
import com.example.libraryMS.entity.Member;
import com.example.libraryMS.services.BookService;
import com.example.libraryMS.services.CheckedOutBookService;
import com.example.libraryMS.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private BookService bookService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private CheckedOutBookService checkedOutBookService;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/available_books")
    public String showAvailableBooks(Model model){
        List<Book> availableBooks = bookService.getAvailableBooks();
        model.addAttribute("books", availableBooks);
        return "books";
    }

    @GetMapping("/members")
    public String showAllMembers(Model model){
        List<Member> members = memberService.getAllMembers();
        model.addAttribute("members", members);
        return "members";
    }

    @GetMapping("/checkedoutbooks")
    public String showCheckedOutBooks(Model model){
        List<CheckedOutBook> items = checkedOutBookService.getBooks();
        model.addAttribute("items", items);
        return "checkedoutbooks";
    }

}
