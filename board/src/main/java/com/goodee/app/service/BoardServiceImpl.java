package com.goodee.app.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.goodee.app.dao.BoardMapper;
import com.goodee.app.dto.BoardDto;
import com.goodee.app.util.MyPageUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

  private final BoardMapper boardMapper;
  private final MyPageUtils myPageUtils;
 
  @Override
  public void loadBoardList(HttpServletRequest request, Model model) {
    
    Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
    String strPage = opt.orElse("1");
    int page = Integer.parseInt(strPage);
    
    int total = boardMapper.getBoardCount();
    
    int display = 10;
    
    myPageUtils.setPaging(page, total, display);
    
    Map<String, Object> map = Map.of("begin", myPageUtils.getBegin()
        , "end", myPageUtils.getEnd());
    
    List<BoardDto> boardList = boardMapper.getBoardList(map);
    
    model.addAttribute("boardList", boardList);
    
    String contextPath = request.getContextPath();
    model.addAttribute("paging", myPageUtils.getMvcPaging(contextPath + "/board/list.do"));
    model.addAttribute("total", total);
  }
  
  @Override
  public int addBoard(BoardDto board) {
    return boardMapper.insertBoard(board);
  }

  @Override
  public BoardDto getBoard(int boardNo) {
    BoardDto board = boardMapper.getBoard(boardNo);
    return board;
  }
  
  @Override
  public int modifyBoard(BoardDto board) {
    return boardMapper.updateBoard(board);
  }
  
  @Override
  public int removeBoard(int boardNo) {
    return boardMapper.deleteBoard(boardNo);
  }
}
