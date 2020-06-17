<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="member" class="com.mission.javabeans.BoardBean"/>
<jsp:setProperty name="member" property="*"/>

<%
	member.setName(request.getParameter("name"));
	member.setPass(request.getParameter("pass"));
	member.setEmail(request.getParameter("email"));
	member.setTitle(request.getParameter("title"));
	member.setContent(request.getParameter("content"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>Action Tag 사용한 방법</h3>
작성자 : <jsp:getProperty name="member" property="name"/><br>
비밀번호 : <jsp:getProperty name="member" property="pass"/><br>
이메일 : <jsp:getProperty name="member" property="email"/><br>
글 제목 : <jsp:getProperty name="member" property="title"/><br>
글 내용 : <jsp:getProperty name="member" property="content"/><br>


<h3>Scriptlet 사용한 방법</h3>
작성자 : <%=member.getName() %><br>
비밀번호 : <%=member.getPass() %><br>
이메일 : <%=member.getEmail() %><br>
글 제목 : <%=member.getTitle() %><br>
글 내용 : <%=member.getContent() %><br>

</body>
</html>