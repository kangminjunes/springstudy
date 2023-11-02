package com.gdu.movie.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gdu.movie.service.MovieService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class FindComedyScheduler {

  private final MovieService movieService;
  
  @Scheduled(cron="0 0 1 1/1 * ?")  // 매일 새벽 1시에 동작
  public void execute() {

  }
  
}