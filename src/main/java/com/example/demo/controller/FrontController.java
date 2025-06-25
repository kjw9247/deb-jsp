package com.example.demo.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("*.do")
@WebServlet("/api/*")
public class FrontController extends HttpServlet{

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 내가 프레임워크 직접 만들어 쓴다
    // /api/common/zipcodeSearch
    String contextPath = req.getContextPath();
    String requestURI = req.getRequestURI();
    System.out.println("requestURI"+requestURI);
    // 맨앞에 / 제외시킨다
    String command = requestURI.substring(contextPath.length()+1); // 이게 뭘 의미하는지 알아보자
    System.out.println("command:"+command);
    String[] pagePath =null; // api, common(업무이름:공통), zipcodeSearch(메서드)
    if (command !=null) {
      pagePath = command.split("/");
    }
    for(String s:pagePath){
      System.out.println(s); // api, common, zipcodeSearch
    }
  }
  
}
