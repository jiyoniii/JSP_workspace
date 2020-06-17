<%@page import="com.saeyan.javabeans.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- java코드로 작성하는 방법. -->
<%
	MemberBean member=new MemberBean();
	member.setName("홍길동");
	member.setUserid("hkd");
	
	out.println(member.getName()+"<br>");
	out.println(member.getUserid()+"<br>");
%>

<!-- action코드로 작성하는 방법 -->
<jsp:useBean id="member2" class="com.saeyan.javabeans.MemberBean"></jsp:useBean>

<!-- setter -->
<jsp:setProperty property="name" name="member2" value="이순신" />
<jsp:setProperty property="userid" name="member2" value="lss"/>

<!-- getter -->
<jsp:getProperty name="member2" property="name"/><br>
<jsp:getProperty name="member2" property="userid"/>



</body>
</html>