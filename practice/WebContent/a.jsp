<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>쿠키를 생성하자</h3>

<%
	//쿠키생성
	Cookie c = new Cookie("id", "hkd");
	//유효기간 설정
	c.setMaxAge(60 * 60 * 24);
	//클라이언트에 쿠키 전송(response가 쿠키 정보를 클라이언트에 저장해주는 역할.)
	response.addCookie(c);
%>

<%
	session.setAttribute("id","hkd");
%>



</body>
</html>