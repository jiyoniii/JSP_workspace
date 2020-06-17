<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- //sessioncheck 파일을 따로 빼서 include 하는 방식으로 짠 코드임 -->
<%@include file="sessionCheck.jsp" %>
	<%=session.getAttribute("loginUser")%>님 안녕하세요!
	<br>

	<form method="post" action="logout.jsp">
		<input type="submit" value="로그아웃">
	</form>
</body>
</html>