package kr.or.bit;
/*
 	전체 프로젝트 ( 회원 : 전체조회, 조건조회, 삽입, 삭제, 수정) 
 	각각의 작업을 하기 위한 공통적인 작업요소
 	1. 드라이버 로딩
 	2. 연결 객체 생성, 명령객체 생성, 자원해제
 	반복적으로 사용
 	====================================
 	개선 ( 리펙토링 : 반복적인 코드의 제거)
 	모든 페이지가 가지고 공통적인 요소를 한곳으로 ..
 	
 	- 공통적인 내용을 가지는 클래스를 만들자 
 	- 편하게 쓸려면 자주 사용하는 함수 > static > overloading > 다형성 
 
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHelper {
	public static Connection getConnection(String dsn) { // oracle , mysql ... 
		Connection conn = null;
		try {
			if(dsn.equals("oracle")) {
				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.76:1521:xe","bituser","1004");
				System.out.println("연결 여부 (false) 연결됨 : " + conn.isClosed());
			}else if(dsn.equals("mysql")) {
				Class.forName("com.mysql.cj.jdbc.Driver");
			    conn = DriverManager.getConnection("jdbc:mysql://192.168.0.218:3306/sampledb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=true","bituser","1004");
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			
		}
		
		return conn;
	}
	
	public static Connection getConnection(String dsn,  String id, String pwd) { // oracle , mysql ... 
		Connection conn = null;
		try {
			if(dsn.equals("oracle")) {
				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.76:1521:xe",id,pwd);
				System.out.println("연결 여부 (false) 연결됨 : " + conn.isClosed());
			}else if(dsn.equals("mysql")) {
				Class.forName("com.mysql.cj.jdbc.Driver");
			    conn = DriverManager.getConnection("jdbc:mysql://192.168.0.218:3306/sampledb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=true","bituser","1004");
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			
		}
		
		return conn;
	}
}
