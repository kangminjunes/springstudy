package com.gdu.movie.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.movie.dto.MovieDto;

@Mapper
public interface MovieMapper {
    int getMovieCount();
    List<MovieDto> getMovieList();
    int getSearchMovieCount(Map<String, Object> map);
    List<MovieDto> getSearchMovieList(Map<String, Object> map);
}
