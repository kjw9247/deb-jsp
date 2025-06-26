package com.example.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberController implements Controller{
  String methodName = null;
  String path = null; // 응답페이지 이름 또는 json() -> 리액트
  public MemberController(String methodName){
    this.methodName = methodName;
  }

  @Override
  public String excute(HttpServletRequest req, HttpServletResponse res) throws Exception {
    if (methodName.equals("회원목록")) {// GET
      // select 처리
      path = "redirect:XXX.jsp";
    } 
    else if (methodName.equals("회원등록")) {// POST
      // insert into 회원 values(?,?,?...)
      path = "redirect:XXX.jsp";
    } 
    else if (methodName.equals("회원수정")) {// PUT
      // update 회원 set mem_name=?, mem_address = ?
      // where 회원 회원아이디 = ?
      path = "redirect:XXX.jsp";
    }
    else if (methodName.equals("회원삭제")) {// DELETE
      // delete from 회원 where 회원아아디 = ?
      path = "redirect:XXX.jsp";
    }
    
    
    return path;
  }

}
