package com.example.loginpractice.controller;

import com.example.loginpractice.model.MemberDtoPost;
import com.example.loginpractice.model.MemberDtoRes;
import com.example.loginpractice.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {
    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity createMember(MemberDtoPost memberDtoPost) {
        memberService.createMember(memberDtoPost);
        return ResponseEntity.ok().body("Member 생성 완료");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/find")
    public ResponseEntity findMemberById(Integer id) {
        MemberDtoRes memberDtoRes = memberService.findMemberById(id);
        return ResponseEntity.ok().body(memberDtoRes);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseEntity findMemberList() {
        List<MemberDtoRes> memberDtoResList=  memberService.findMemberList();
        return ResponseEntity.ok().body(memberDtoResList);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    public ResponseEntity updateMember(MemberDtoPost memberDtoPost) {
        memberService.updateMember(memberDtoPost);
        return ResponseEntity.ok().body("Member 수정 완료");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public ResponseEntity deleteMember(Integer id) {
        memberService.deleteMember(id);
        return ResponseEntity.ok().body("Member 삭제 완료");
    }

}
