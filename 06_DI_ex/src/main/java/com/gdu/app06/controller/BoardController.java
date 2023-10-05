package com.gdu.app06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.app06.service.IBoardService;

@Controller
public class BoardController {

  private IBoardService iBoardService;

  @Autowired
  public void setiBoardSerivce(IBoardService iBoardSerivce) {
    this.iBoardService = iBoardSerivce;
  }
  
  @RequestMapping(value="/board/list.do", method=RequestMethod.GET)
  public String list(Model model) {
    model.addAttribute("boardList", iBoardService.getBoardList());
    return "board/list";  //  /WEB-INF/view/board/list.jsp
  }
  
  @RequestMapping(value="/board/detail.do", method=RequestMethod.GET)
  public String detail(@RequestParam(value="boardNo", required=false, defaultValue="0") int boardNo
                      , Model model) {
   model.addAttribute("board", iBoardService.getBoardByNo(boardNo));
   return "board/detail"; // /WEB_INF/views/board/detail.jsp
  }
    
}
