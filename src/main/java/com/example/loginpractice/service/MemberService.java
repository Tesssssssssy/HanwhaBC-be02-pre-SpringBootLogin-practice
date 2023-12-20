package com.example.loginpractice.service;

import com.example.loginpractice.model.Member;
import com.example.loginpractice.model.MemberDtoPost;
import com.example.loginpractice.model.MemberDtoRes;
import com.example.loginpractice.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void createMember(MemberDtoPost memberDtoPost) {
        memberRepository.save(Member.builder()
                        .email(memberDtoPost.getEmail())
                        .password(memberDtoPost.getPassword())
                        .build());
    }

    public MemberDtoRes findMemberById(Integer id) {
        Optional<Member> result = memberRepository.findById(id);

        if (result.isPresent()) {
            Member member = result.get();

            return MemberDtoRes.builder()
                    .id(member.getId())
                    .email(member.getEmail())
                    .build();

        } else {
            return null;
        }
    }

    public List<MemberDtoRes> findMemberList() {
        // Member Entity -> MemberDto로 바꿔줘야 함.
        List<Member> result = memberRepository.findAll();

        List<MemberDtoRes> memberDtoResList = new ArrayList<>();

        if (!result.isEmpty()) {
            for (Member member : result) {
                MemberDtoRes memberDtoRes = MemberDtoRes.builder()
                        .id(member.getId())
                        .email(member.getEmail())
                        .build();
                memberDtoResList.add(memberDtoRes);
            }
            return memberDtoResList;
        } else {
            return null;
        }
    }

    public void updateMember(MemberDtoPost memberDtoPost) {
        Optional<Member> result = memberRepository.findById(memberDtoPost.getId());

        if (result.isPresent()) {
            Member member = result.get();
            member.setEmail(memberDtoPost.getEmail());
            member.setPassword(memberDtoPost.getPassword());
            memberRepository.save(member);
        }
    }

    public void deleteMember(Integer id) {
        memberRepository.delete(Member.builder().id(id).build());
    }
}
