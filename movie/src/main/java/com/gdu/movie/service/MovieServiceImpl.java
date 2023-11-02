package com.gdu.movie.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.gdu.movie.dao.MovieMapper;
import com.gdu.movie.dto.MovieDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MovieServiceImpl implements MovieService {

  private final MovieMapper movieMapper;
  
  @Override
  public Map<String, Object> getMovieList() {
    
    int movieCount = movieMapper.getMovieCount();
    List<MovieDto> list = movieMapper.getMovieList();
    
    return Map.of("message", "전체" + movieCount + "개의 목록을 가져왔습니다."
                , "list", list
                , "status", 200);
    
  }
  
  @Override
  public Map<String, Object> getSearchMovieList(String title) {
      Map<String, Object> parameterMap = new HashMap<>();
      parameterMap.put("title", title);

      List<MovieDto> movieList = movieMapper.getSearchMovieList(parameterMap);
      int searchMovieCount = movieMapper.getSearchMovieCount(parameterMap);

      return Map.of("message", "검색 내용 영화 " + searchMovieCount + "개의 목록을 가져왔습니다.", "list", movieList, "status", 300);
  }
}