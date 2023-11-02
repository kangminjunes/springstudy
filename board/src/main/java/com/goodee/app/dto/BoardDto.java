package com.goodee.app.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardDto {
  private int boardNo;
  private String writer;
  private String title;
  private String contents;
  private Date createdAt;
  private Date modifiedAt;
  
}
