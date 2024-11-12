package com.example.libraryMS.controller;

import com.example.libraryMS.entity.Book;
import com.example.libraryMS.entity.Member;
import com.example.libraryMS.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @DeleteMapping("/{jmbg}")
    public ResponseEntity<Void> deleteEntity(@PathVariable String jmbg){
        boolean isDeleted = memberService.deleteMemberByJmbg(jmbg);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }

}
    @PostMapping("/addnewmember")
    public ResponseEntity<String> addNewMember(@RequestBody Member member) {
        try {
            memberService.saveMember(member);
            return ResponseEntity.status(HttpStatus.CREATED).body("Member added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving member: " + e.getMessage());
        }
    }

    @PutMapping("/{jmbg}")
    public ResponseEntity<String> editMember(@PathVariable String jmbg, @RequestBody Member member){
        try {
            memberService.updateMemberByJmbg(jmbg, member);
            return ResponseEntity.status(HttpStatus.CREATED).body("Member added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving member: " + e.getMessage());
        }
    }

}
