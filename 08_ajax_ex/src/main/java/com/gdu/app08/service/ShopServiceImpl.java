package com.gdu.app08.service;

import org.springframework.util.LinkedMultiValueMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopServiceImpl {

  private String query;     // 검색어
  private Integer display;  // 검색 결과 갯수 
  private String sort;      // 검색어 정확도순 
  
  public MultiValueMap map () {
    LinkedMultiValueMap<String, String> map = new LinkMultiValueMap();
    map.add("query", query);
    map.add("display", String.valueOf(display));
    map.add("sort", sort);
  }
  
}
