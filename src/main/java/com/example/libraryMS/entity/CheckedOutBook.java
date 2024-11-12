package com.example.libraryMS.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class CheckedOutBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "member_jmbg", referencedColumnName = "jmbg")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "book_isbn", referencedColumnName = "isbn")
    private Book book;

    private Date checkoutDate;

    public CheckedOutBook(){

    }

    public CheckedOutBook(Member member, Book book, Date checkoutDate) {
        this.member = member;
        this.book = book;
        this.checkoutDate = checkoutDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }
}
