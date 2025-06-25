package com.example.demo.util;
// JDBC API 활용 -> 원시적인 방법 - 순수 - 유행을 타지 X
// -> MyBatis(오픈SQL매핑소스)
// -> Hibernate(JPA) - 쿼리문이 없는데 DB연동이 된다
import java.sql.*;

public class DBConnectionMgr {
    // 변수 앞에 static 있다 - 공유 - 싱글톤
    private static DBConnectionMgr dbMgr = null;
    // 오라클 회사가 제공하는 드라이버 클래스 이름
    private final String _DRIVER = "oracle.jdbc.driver.OracleDriver";
    // 멀티티어 환경에서는 thin 드라이버 방식 사용함.(oci 로컬)
    // 1521번은 오라클 서버의 포트 번호, orcl11 - SID 이름
    private final String _URL = "jdbc:oracle:thin:@localhost:1521:orcl11";
    private final String _USER = "scott"; // 계정이름 / 소유주
    private final String _PASSWORD = "tiger"; // 비번
    private DBConnectionMgr() { // 생성자
        try {
            Class.forName(_DRIVER); // 오라클 회사 드라이버 클래스 로딩
        } catch (ClassNotFoundException e) {
            System.out.println("Can't load JDBC driver");
        }
    }// end of 디폴트 생성자 - 접근제한자를 private함
    //싱글톤
    // A a = new A();
    // Parent p = new Child(); // 다형성
    // 싱글톤 - 메서드 활용 객체 주입 받는다 if문 사용 가능
    // 메서드 앞에 synchronized 붙이면 인터셉트 당하지 않음
    public static synchronized DBConnectionMgr getInstance() {
        if (dbMgr == null) {
            dbMgr = new  DBConnectionMgr();
        }
        return dbMgr;
    }// 외부에서 객체 주입을 받을 때 호출하는 메서드
    // 물리적으로 떨어져 있는 서버에 연결 통로 확보
    // 리턴타입이 인터페이스이다
    public Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(_URL, _USER, _PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }// end of getConnection
    // 다 사용하고 나면 사용한 자원 반납함
    // 반납시에는 생성된 역순으로 한다
    public void freeConnection(Connection conn, Statement stmt, ResultSet rs){
        try {
            if(rs != null){
                rs.close();
            }
            if(stmt != null){
                stmt.close();
            }
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
