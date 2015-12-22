<%@ page contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script>
		function fnUpdate(){
			location.href="update.board?b_seq=" + ${dto["b_seq"]};
		}
		
		function fnDelete(){
			location.href="delete.board?b_seq=" + ${dto["b_seq"]};
		}
	</script>
</head>
<body>
	<div aling="center">
		<h1>글보기 페이지</h1>
		<table border="1">
			<tr>
				<td>글번호</td>
				<td>${dto["b_seq"]}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>${dto["b_title"]}</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>${dto["b_content"]}</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="수정하기" onclick="fnUpdate()"/>
					<input type="button" value="삭제하기" onclick="fnDelete()"/>
					<input type="button" value="목록보기" onclick="location.href='list.board'"/>
				</td>
				<td></td>
			</tr>
		</table>
	</div>
</body>
</html>