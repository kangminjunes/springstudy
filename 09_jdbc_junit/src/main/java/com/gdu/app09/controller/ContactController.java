package com.gdu.app09.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdu.app09.dto.ContactDto;
import com.gdu.app09.service.ContactService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j // private static final Logger log = LoggerFactory.getLogger(ContactController.class);
@RequiredArgsConstructor  //  private final ContactService contactService; 에 @Autowired를 하기 위한 코드이다.
@Controller
public class ContactController {
  
  // ContactController 가 실행할 떄 org.slf4j.Logger가 동작한다.
  // private static final Logger log = LoggerFactory.getLogger(ContactController.class);

  private final ContactService contactService;
  
  @RequestMapping(value="/contact/list.do", method=RequestMethod.GET)
  public String list(Model model) { 
    log.info("");
    List<ContactDto> contactList = contactService.getContactList();
    model.addAttribute("contactList", contactList);
    return "contact/list";
  }
  
  @RequestMapping(value="/contact/write.do", method=RequestMethod.GET)
  public String write() {
    return "contact/write";
  }
  
  @RequestMapping(value="/contact/add.do", method=RequestMethod.POST)
  public String add(ContactDto contactDto, RedirectAttributes redirectAttributes) {
    log.info("add:" + contactDto);
    int addResult = contactService.addContact(contactDto);
    redirectAttributes.addFlashAttribute("addResult", addResult);
    return "redirect:/contact/list.do";
  }
  
  @RequestMapping(value="/contact/detail.do", method=RequestMethod.GET)
  public String detail(@RequestParam(value="contact_no", required=false, defaultValue="0") int contact_no, Model model) {
    log.info("detail:" + contact_no);
    model.addAttribute("contact", contactService.getContactByNo(contact_no));
    return "contact/detail";
  }
  
  @RequestMapping(value="/contact/modify.do", method=RequestMethod.POST)
  public String modify(ContactDto contactDto, RedirectAttributes redirectAttributes) {
    log.info("modify:" + contactDto);
    int modifyResult = contactService.modifyContact(contactDto);
    redirectAttributes.addFlashAttribute("modifyResult", modifyResult);
    return "redirect:/contact/detail.do?contact_no=" + contactDto.getContact_no();
  }
  
  @RequestMapping(value="/contact/delete.do", method=RequestMethod.POST)
  public String delete(@RequestParam(value="contact_no", required=false, defaultValue="0") int contact_no, RedirectAttributes redirectAttributes) {
    log.info("delete:" + contact_no);
  int deleteResult = contactService.deleteContact(contact_no);
  redirectAttributes.addFlashAttribute("deleteResult", deleteResult);
  return "redirect:/contact/list.do";
  }
  
}
