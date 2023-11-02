package com.goodee.app.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.goodee.app.dto.BoardDto;

public interface BoardService {
  public void loadBoardList(HttpServletRequest request, Model model);
  public int addBoard(BoardDto board);
  public BoardDto getBoard(int boardNo);
  public int modifyBoard (BoardDto board);
  public int removeBoard(int boardNo);
}
