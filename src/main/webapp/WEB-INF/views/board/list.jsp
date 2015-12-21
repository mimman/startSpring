<%@ page contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>list 페이지</title>
</head>
<body>
	<h1>리스트 페이지</h1>
	<a href="">글쓰기</a>
	<br />
	<br />
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>등록자</td>
			<td>등록일</td>
			<td>조회수</td>
		</tr>
		<c:forEach var="dto" items="${list}"> 
		<tr>
			<td>${dto.getB_seq()}</td>
			<td>${dto.getB_title()}</td>
			<td>${dto.getB_writer()}</td>
			<td>${dto.getB_regdate()}</td>
			<td>${dto.getB_hitcount()}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>