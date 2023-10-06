package com.gdu.app08.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShopService {
  
  public String search(String query) {
      try { // 검색어 인코딩
        query = URLEncoder.encode(query, "UTF-8"); 
      } catch (UnsupportedEncodingException e) {
        throw new RuntimeException("검색어 인코딩 실패" , e);
      }
  }
  
  // URI api 세팅
  
  private final String apiURL= "https://openapi.naver.com/v1/search/shop.json";
  
  Map<String, String> requestHeader = new HashMap<>();
    requestHeaders.put("jRFHzWTrREsctftYPAq6", clientId);
    requestHeaders.put("9dSQdrH0QD", clientSecret);
    String responseBody
}
