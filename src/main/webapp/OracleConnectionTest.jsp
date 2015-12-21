<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page  contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
</head>
<body>
<h1>오라클 연결 테스트</h1>
<%
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		Connection con = DriverManager.getConnection(url,"scott","1111");
		
		if(con != null){
			out.println("연결 성공");
		}
	}catch(Exception err){
		System.out.println("연결실패 : " + err);
	}
%>
</body>
</html>