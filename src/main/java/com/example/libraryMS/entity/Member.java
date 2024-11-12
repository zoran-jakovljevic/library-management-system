package com.example.libraryMS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Member {
    @Id
    private String jmbg;

    private String name;
    private String address;
    private String phone_number;
    private Date entry_date;
    private Date expiry_date;

    public Member(){

    }

    public Member(String jmbg, String name, String address, String phone_number, Date entry_date, Date expiry_date){
        this.jmbg = jmbg;
        this.name = name;
        this.address = address;
        this.phone_number = phone_number;
        this.entry_date = entry_date;
        this.expiry_date = expiry_date;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Date getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(Date entry_date) {
        this.entry_date = entry_date;
    }

    public Date getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(Date expiry_date) {
        this.expiry_date = expiry_date;
    }
}
