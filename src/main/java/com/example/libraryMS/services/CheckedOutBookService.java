package com.example.libraryMS.services;

import com.example.libraryMS.entity.Book;
import com.example.libraryMS.entity.CheckedOutBook;
import com.example.libraryMS.entity.Member;
import com.example.libraryMS.repository.BookRepository;
import com.example.libraryMS.repository.CheckedOutBookRepository;
import com.example.libraryMS.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CheckedOutBookService {

    @Autowired
    private CheckedOutBookRepository checkedOutBookRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BookRepository bookRepository;

    public boolean checkedOutBooks(String memberJmbg, String bookIsbn){

        Member member = memberRepository.findByJmbg(memberJmbg);
        Book book = bookRepository.findByIsbn(bookIsbn);

        CheckedOutBook checkedOutBook = new CheckedOutBook(member, book, new Date());

        if (member != null && book != null){
            checkedOutBookRepository.save(checkedOutBook);
            return true;
        } else {
            return false;
        }

    }

    public List<CheckedOutBook> getBooks(){
        return checkedOutBookRepository.findAll();
    }

    public void deleteByMemberJmbg(String jmbg) {
        checkedOutBookRepository.deleteByMemberJmbg(jmbg);
    }

    public boolean deleteById(Integer id) {
        Optional<CheckedOutBook> checkedOutBook = checkedOutBookRepository.findById(id);
        if (checkedOutBook.isPresent()) {
            checkedOutBookRepository.deleteById(id);
            return true;
        }
        return false;
    }



}
