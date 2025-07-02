package com.example.demo.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
// NullPointerException 디버깅
// 요청객체는 서블릿만 가질 수 있다 - doGet, doPost, doPut, doDelete
public class HashMapBinder {
  HttpServletRequest req = null; // 외부에서 가져오는데 글로벌하게 쓰고 싶다면 초기화는 null 원본을 쓰려고 하기 때문에
  public HashMapBinder(HttpServletRequest req){
    this.req = req; // 이부분이 없으면 밑의 req가 null이 되버림
  }
  // 파라미터로 부터 자료구조를 받아온다 -pmap
  public void binder(Map<String,Object> pmap){
    pmap.clear(); // 새로 담기 위해서 기존에 정보가 담겨 있다면 비우기 위해
    Enumeration<String> en = req.getParameterNames(); // id, passwd, name,,,
    while (en.hasMoreElements()) {
      String key = en.nextElement(); // id, passwd, name,,,
      pmap.put(key,req.getParameter(key));
    } // end of while
  } // end of binder
}

/*
<Input type="text" name="id">
String id = request.getParameter("id")''
<Input type="text" name="passwd">
String id = request.getParameter("passwd")''
<Input type="text" name="name">
String id = request.getParameter("name")''

 */