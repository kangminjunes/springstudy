package com.gdu.app05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gdu.app05.service.BoardService;

@Controller // 컨트롤러 전용 @Component
public class BoardController {

  // 해당 부분은 BoardServiceImpl.java에서 @Component를 통해 전송할데이터를
  // 3가지 방법중 한개로 필드에 주입 @Autowired한것이다.
  // 해당 final 처리시 2번쨰 방법 생성자에 주입하기 방식만 사용 가능하다
  
  /******************************  DI  **************************************************/
  
  // 주입된 boardService 객체의 변경 방지를 위해 final 처리한다. 
  private final BoardService boardService;

  // boardService에 final 처리를 하면 생성자 주입만 가능하다. ( 필드 주입과 Setter 주입은 불가능하다)
  // 생성자 주입의 @Autowired는 생략할 수 있으므로 @RequiredArgsConstructor와 같은 Annotation으로 대체할 수 있다.
  @Autowired
  public BoardController(BoardService boardService) {
    super();
    this.boardService = boardService;
  }
  
  /****************************   Method  ***************************************************/

  @RequestMapping(value="/board/list.do", method=RequestMethod.GET)
  public String list(Model model) {
    model.addAttribute("boardList", boardService.getBoardList());
    return "board/list";
  }
  
}