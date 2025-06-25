package com.example.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.example.demo.dao.DeptDao;
import com.example.demo.vo.DeptVO;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
/*
 * 오라클 서버 연동하기
 * 웹 브라우저를 통해서 출력을 내보낸다
 * http/https 프로토콜이 필요하다
 * 웹 서버가 필요하다 -> WAS(Web Application Server)
 * src/main/resources/application.yml - 8000 포트 설정
 * CORS 이슈 - proxy설정 - setProxy.js
 * GET요청 - doGet
 * POST요청 - doPost
 * PUT요청 - doPut
 * DELETE요청 - doDelete
 * 서블릿을 상속 받으면 doGet, doPost, doPut, doDelete 지원받음 - Overriding
 * DeptServlet is a HttpServlet
 * 소나타 is a 자동차 이다
 * doGet(req, res) - 메서드 파라미터 자리는 번수 선언이다(지역변수)
 * 선언만 되어 있다 -> 사용시 NullPinterException이 발생 할 수도 있다 
 * live Server에는 jsp 엔진과 servlet 엔진이 없다
 * 톰켓 서버이어야 doGet파라미터 자리에 req,res를 주입 받을 수 있다
 */
@Log4j2
@WebServlet("/dept/jsonDeptList")
public class DeptServlet extends HttpServlet{
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    log.info("doPost 호출 성공");
    res.sendRedirect("./deptList.jsp");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    log.info("doGet 호출 성공");
    // 오라클 서버와 연동하는 클래스인 DeptDao생성하기
    DeptDao deptDao = new DeptDao();
    // 인스턴스 변수로 deptList()호출하였다
    // 대입 연산자를 통해서 select한 결과를 리턴 받음
    List<DeptVO> list = deptDao.deptList();
    // UI/UX솔루션, 리액트, Vue.js, Angular.js - 언어에 제약이 없는 데이터 포맷이
    // 필요하다 -> JSON -> application/json
    Gson gson = new Gson();
    String temp = gson.toJson(list);
    // log.info(temp);
    res.setContentType("application/json;charset=utf-8");
    PrintWriter out = res.getWriter();
    // -> http://localhost:8000/dept/jsonDeptList 요청이고 GET방식이다
    // 위와 같이 요청을 하면 브라우저에 URL에 입력되므로 처리 주체가 브라우저임
    out.println(temp);
    // out.flush();
    out.close();
  }
  
}
