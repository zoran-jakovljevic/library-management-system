package com.example.libraryMS.services;

import com.example.libraryMS.entity.Member;
import com.example.libraryMS.repository.CheckedOutBookRepository;
import com.example.libraryMS.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private CheckedOutBookRepository checkedOutBookRepository;

    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }

    public Member findMemberByJmbg(String jmbg){
        return memberRepository.findByJmbg(jmbg);
    }

    public void saveMember(Member member) {
        memberRepository.save(member);
    }

    public boolean deleteMemberByJmbg(String jmbg) {
        Member member = memberRepository.findByJmbg(jmbg);
        if (member != null) {
            checkedOutBookRepository.deleteByMemberJmbg(jmbg);
            memberRepository.delete(member);
            return true;
        }
        return false;
    }

    public void updateMemberByJmbg(String jmbg, Member updatedMember){
        Optional<Member> existingMember = memberRepository.findById(jmbg);
        if(existingMember.isPresent()){
            Member member = existingMember.get();
            member.setName(updatedMember.getName());
            member.setAddress(updatedMember.getAddress());
            member.setPhone_number(updatedMember.getPhone_number());
            member.setEntry_date(updatedMember.getEntry_date());
            member.setExpiry_date(updatedMember.getExpiry_date());
            memberRepository.save(member);
        }
    }
}


