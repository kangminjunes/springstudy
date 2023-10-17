package com.gdu.app14.service;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.gdu.app14.dto.MemberDto;

public interface MemberService {

  // 회원 등록
  public Map<String, Object> register(MemberDto memberDto, HttpServletResponse response);
  
  // 회원 목록
  public Map<String, Object> getMembers(int page);
  
  // 회원 조회 (만약넘기는 데이터가 한개면 MemberDto로 가능하다)
  public Map<String, Object> getMember(int memberNo);
  
  // 회원 정보 수정
  public Map<String, Object> modifyMember(MemberDto memberDto);   
  
  
  
  
  
}