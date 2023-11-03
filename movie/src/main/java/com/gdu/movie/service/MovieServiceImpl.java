package com.gdu.movie.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gdu.movie.dao.MovieMapper;
import com.gdu.movie.dto.MovieDto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MovieServiceImpl implements MovieService {

    private final MovieMapper movieMapper;

    @Override
    public Map<String, Object> getMovieList() {
        int movieCount = movieMapper.getMovieCount();
        List<MovieDto> list = movieMapper.getMovieList();
        String message = list.isEmpty() ? "현재 영화 목록이 없습니다." : "전체 " + movieCount + "개의 목록을 가져왔습니다.";

        return Map.of("message", message, "list", list, "status", 200);
    }

    @Override
    public Map<String, Object> getSearchMovieList(String title) {
        Map<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("title", title);

        List<MovieDto> movieList = movieMapper.getSearchMovieList(parameterMap);
        int searchMovieCount = movieMapper.getSearchMovieCount(parameterMap);
        String message = movieList.isEmpty() ? "검색 결과가 없습니다." : "검색 내용 영화 " + searchMovieCount + "개의 목록을 가져왔습니다.";

        return Map.of("message", message, "list", movieList, "status", 300);
    }
}
