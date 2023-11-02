package com.goodee.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.goodee.app.dto.BoardDto;
import com.goodee.app.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BoardController {

  private final BoardService boardService;
  
  
  // 목록
  @GetMapping("list.do")
  public String list(HttpServletRequest request, Model model) {
    boardService.loadBoardList(request, model);
    return "board/list";
  }
  
  @RequestMapping(value="/board/write.do", method=RequestMethod.GET)
  public String write() {
    return "board/write";
  }
  
  // insert는 redirectAttributes에 저장한 뒤 redirect한다.
  @PostMapping("/add.do")
  public String add(BoardDto board, RedirectAttributes attr) {
    int addResult = boardService.addBoard(board);
    attr.addFlashAttribute("addResult", addResult);
    return "redirect:/list.do";
  } 
  // 상세보기 
  @GetMapping("/detail.do")
  public String detail(@RequestParam(value="boardNo", required=false, defaultValue="0") int boardNo
                     , Model model) {
    BoardDto board = boardService.getBoard(boardNo);
    model.addAttribute("board", board);
    return "board/detail";
  }
  
  @PostMapping("/modify.do")
  public String modify(BoardDto board, RedirectAttributes attr) {
    int modifyResult = boardService.modifyBoard(board);
    attr.addFlashAttribute("modifyResult", modifyResult);
    return "redirect:/list.do";
  }
  
  @PostMapping("/remove.do")
  public String remove(@RequestParam(value="boardNo", required=false, defaultValue="0") int boardNo
                     , RedirectAttributes attr) {
    int removeResult = boardService.removeBoard(boardNo);
    attr.addFlashAttribute("removeResult", removeResult);
    return "redirect:/list.do";
  }

}
