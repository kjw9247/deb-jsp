<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>
<%@ page import="java.util.ArrayList, java.util.HashMap" %>
<%@ page import="com.google.gson.Gson" %>
<%
  // http://localhost:8000/common/jsonZipCode.jsp
  // json -> List<VO>, List<Map>
  // List<VO>, List<Map> -> json
  List<Map<String, Object>> list = new ArrayList<>();
  Map<String, Object> map = new HashMap<>(); // Map은 인터페이스이기 때문에 단일로 생성불가
  map.put("zipcode", 25678);
  map.put("address", "서울시 마포구 공덕동");
  list.add(map); // list.size() =1 <- 로우 , map.size()= 2 <- 컬럼
  map = new HashMap();
  map.put("zipcode", 25688);
  map.put("address", "서울시 영등포구 당산동");
  list.add(map);
  Gson g = new Gson();
  String temp = g.toJson(list);
  out.print(temp);
%>



















// 마임 타입 매우 중요
