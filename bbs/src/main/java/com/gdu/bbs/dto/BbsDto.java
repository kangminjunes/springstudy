package com.gdu.bbs.dto;

import java.security.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BbsDto {
  private int bbsNo;
  private String editor;
  private String title;
  private String contents;
  private Timestamp createdAt;
  private Timestamp modifiedAt;
}