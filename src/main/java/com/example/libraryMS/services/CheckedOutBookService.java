package com.example.libraryMS.services;

import com.example.libraryMS.entity.Book;
import com.example.libraryMS.entity.CheckedOutBook;
import com.example.libraryMS.entity.Member;
import com.example.libraryMS.repository.CheckedOutBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CheckedOutBookService {

    @Autowired
    private CheckedOutBookRepository checkedOutBookRepository;

    public CheckedOutBook checkedOutBooks(Member member, Book book){
        CheckedOutBook checkedOutBook = new CheckedOutBook(member, book, new Date());
        return checkedOutBookRepository.save(checkedOutBook);
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
