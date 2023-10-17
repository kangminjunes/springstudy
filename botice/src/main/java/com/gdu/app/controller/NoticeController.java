package com.gdu.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdu.app.dto.NoticeDto;
import com.gdu.app.service.NoticeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class NoticeController {

  private final NoticeService noticeService;
  
  // value 값과 return 값은 관련이없으니 헷갈리지 말거 아예 다른거다 
  // value : a/b return : c/b 는 다른거다.  
  
  // 목록보기
  @RequestMapping(value="/notice/list.do", method = RequestMethod.GET) 
  public String list(Model model) { // forward할 데이터는 Model에 저장한다.
    List<NoticeDto> noticeList = noticeService.getNoticeList();
    model.addAttribute("noticeList", noticeList); // forward할 데이터 저장하기(저장한 이름은 noticeList)
    return "notice/list";   // notice 폴더 아래의 list.jsp로 forward하시오
  }
  
  // 추가하기
  @RequestMapping(value="/notice/write.do", method = RequestMethod.GET)
  public String write() {
    return "notice/write";
  }
  
  // 수정 save = 
  @RequestMapping(value="/notice/save.do", method = RequestMethod.POST)
  public String save(NoticeDto noticeDto, RedirectAttributes redirectAttributes) { // redirect할 데이터는 RedirectAttributes에 저장한다.
    int addResult = noticeService.addNotice(noticeDto);
    redirectAttributes.addFlashAttribute("addResult", addResult);
    return "redirect:/notice/list.do";
  }
  
  @RequestMapping(value="/notice/detail.do", method = RequestMethod.GET)
  public String detail(@RequestParam int noticeNo, Model model) {
     NoticeDto noticeDto = noticeService.getNotice(noticeNo);
     model.addAttribute("notice", noticeDto);   
    return "notice/detail"; // notice 폴더 아래 detail.jsp로 notice를 보낸다.
  }
  
  // 편집하기
  @RequestMapping(value="/notice/modify.do", method = RequestMethod.POST)
  public String modify(NoticeDto noticeDto, RedirectAttributes redirectAttributes) {
    int  modifyResult = noticeService.modifyNotice(noticeDto);
    redirectAttributes.addFlashAttribute("modifyResult", modifyResult);
    return "redirect:/notice/detail.do?noticeNo=" + noticeDto.getNoticeNo();
    
  // 삭제하기
    @RequestMapping(value="/notice/delete.do", method = RequestMethod.POST)
    public String delete(@RequestParam(value="noticeNo", required=false, defaultValue="0") int noticeNo, RedirectAttributes redirectAttributes) {
     int deleteResult = noticeService.deleteNotice(noticeNo); 
      redirectAttributes.addFlashAttribute("deleteResult", deleteResult);
      return "redirect:/notice/list.do";
    }
  }
}
