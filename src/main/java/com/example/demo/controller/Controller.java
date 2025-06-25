package com.example.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
// doGet(req, res)      (req, res)<- 요청객체와 응답객체가 꼭필요하다 왜? 웹서비스를 할거기 때문
// doPost(req, res)
// doPut(req, res)
// doDelete(req, res)
// execute는 내가 설계한 메서드 이름
// 문제는 톰켓서보로 부터 어떻게 요청객체와 응답객체를 주입 받을 것인가?
// pass by value, refer by value(이것으로 해결한다)
// 요청객체와 응답객체는 개발자 정의하지 않는다 - WAS


public interface Controller {
  public String excute(HttpServletRequest req, HttpServletResponse res)
  throws Exception; 
}
