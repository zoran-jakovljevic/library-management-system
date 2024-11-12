package com.example.libraryMS.repository;

import com.example.libraryMS.entity.CheckedOutBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckedOutBookRepository extends JpaRepository<CheckedOutBook, Integer> {

    void deleteByMemberJmbg(String jmbg);
}