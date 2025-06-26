package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import com.example.demo.dao.ZipCodeDao;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class CommonController implements Controller{
  String methodName = null;
  String path = null;
  ZipCodeDao zDao = null;
  public CommonController(String methodName){
    zDao = new ZipCodeDao();
    this.methodName = methodName;
    log.info(methodName);
  }
  @Override
  public String excute(HttpServletRequest req, HttpServletResponse res) throws Exception {
    // http://localhost:8000/api/common/zipcodeSearch?dong=가산
    if (methodName.equals("zipcodeSearch")) {
      log.info("우편번호 찾기 호출 성공");
      List<Map<String, Object>> zlist = null;
      // execute 메서드의 파라미터에 req는 HttpServlet에서 온 것이다
      // HttpServlet을 상속 받은 클래스가 FrontController이었다
      // 그 원본이 CommonController execute 메서드 파라미터 객체와 일치한다
      zlist = zDao.zipcodeList(req.getParameter("dong"));
      req.setAttribute("zlist", zlist);
      path = "forward:/common/jsonZipCodeList.jsp";
    } 
    else if (methodName.equals("공통등록")) {

      path = "redirect:XXX.jsp";
    } 
    else if (methodName.equals("공통수정")) {

      path = "redirect:XXX.jsp";
    }
    else if (methodName.equals("공통삭제")) {
      path = "redirect:XXX.jsp";
    }
    /* else{
      path = "redirect:error.jsp";
    } */
    return path;
  }
}
