package com.gdu.app03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController02 {

  // Spring 4 버전 이후 사용 가능한 @RequestMapping
  // 1. @GetMapping
  // 2. @PostMapping
  
  @GetMapping(value="/notice/list.do")
  public String noticeList() {   // 해당 메소드가 가지는 이름의의미는없다
    // ViewResolver의 prefix : /WEB-INF/views/
    // ViewResolver의 suffix : .jsp
    return "notice/list";  //  /WEB-INF/views/notice/list.jsp;
  }
  
  // 반환이 없는 경우에는 주소 요청 주소를 Jsp 경로로 인식한다.
  // /member/list.do 요청을 /member/list.jsp 경로로 인식한다.
  // /member/list    요청을 /member/list.jsp 경로로 인식한다.
  // 여러개의 요청을 하고싶다면 {} 중괄호를 활용하여 배열로 만드면된다.
  @GetMapping(value={"/member/list.do","/member/list"})
  public void memberList() {
    
  }
  
}
