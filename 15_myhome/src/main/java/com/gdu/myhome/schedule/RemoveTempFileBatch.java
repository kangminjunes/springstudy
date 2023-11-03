package com.gdu.myhome.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gdu.myhome.service.UploadService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class RemoveTempFileBatch {

  private final UploadService uploadService;
  
  @Scheduled(cron="0 0 12 * * ?")   // 매일 12시 기준으로 필요없는 압축 파일을 삭제한다.
  public void execute() {
    uploadService.removeTempFiles();
  }
  
}
