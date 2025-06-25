package com.example.demo.controller;
// pagePath[2] = 메서드 이름
// Dao - data access object
// 주문관리 - OrderController - OrderService - OrderDao
// - Oracle, MySql, SQLServer, DB2, INfamix, ,,,
// 회원관리 - MemberController - MemberService - MemberDao
// 게시판 - BoardController - BoardService - BoardDao
// XXXService + XXXDao = 모델계층 ( data )
public class ControllerMapping {
  /***********************************************
   * 
   * @param command - api 떼고 가져온다
   * 예) dept/crudDept, emp/crudEmp, board/crudBoard
   * @return
   ***********************************************/
  public static Controller getController(String command){
    Controller controller = null;
    String [] commands = command.split("/");
    String workname = commands[0]; // 업무이름 - 폴더이름
    String methodName = commands[1]; // 메서드이름
    if ("member".equals(workname)) {
      controller = new MemberController();

    }else if ("board".equals(workname)) {
      controller = new BoardController();
    }
    return controller;
  }
  
}
