<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>쿠키를 가져오자!</h3>
<%
Cookie[] cookies = request.getCookies(); 
	for(Cookie c : cookies )
	out.println(c.getName()+" : "+c.getValue()+"<br>");
%>


<h3>세션값 가져오자!</h3>

<%
	String id=(String) session.getAttribute("id");
%>

id: <%= id %>

</body>
</html>