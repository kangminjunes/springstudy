package com.gdu.app02.anno02;

import java.sql.Connection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MyJdbcDao {
  
  private Connection con;
  private MyJdbcConnection myJdbcConnection;
  
  private Connection getConnection() {
    AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    myJdbcConnection  = ctx.getBean(MyJdbcConnection.class); // Bean 이름은 첫 글자를 소문자로 시작하는 것이 관례
    ctx.close();
    return myJdbcConnection.getConnection();  
  }
  
  private void close() {
    try {
      if(con != null) {
        con.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public void add() {
    con = getConnection();
    System.out.println("add() 호출");
    close();
  }
}
