<%@page import="kr.or.bit.SingletonHelper"%>
<%@page import="kr.or.bit.ConnectionHelper"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Connection conn = null;
    	conn = ConnectionHelper.getConnection("oracle");
    	System.out.println(conn);
    	conn.close();
    	
    	conn = ConnectionHelper.getConnection("oracle", "hr", "1004"); 
    	System.out.println(conn);
    	// conn 객체 정보
    	
    	Connection c = null;
    	c = SingletonHelper.singnew("oracle");
    	System.out.println(c);
    	c.close();
    	
    	Connection c2 = null;
    	c2 = SingletonHelper.singnew("oracle");
    	System.out.println(c2);
    	c.close();
    	
    	// 5개의 Page >> DB연결 >>  ConnectionHelper.getConnection("oracle"); >> 새로운 객체
    	// 하나의 연결 객체를 만들어서 사용하면 되지 (공) 않을까 => singleton (학습용) => 현업(DB) (POOL) 
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 연결 여부 : <%= conn.isClosed() %>
 재정의 	: <%= conn.toString() %>
 ProductName : <%= conn.getMetaData().getDatabaseProductName() %> <br>
 ProductVersion : <%= conn.getMetaData().getDatabaseProductVersion()%>  <br> 
</body>
</html>