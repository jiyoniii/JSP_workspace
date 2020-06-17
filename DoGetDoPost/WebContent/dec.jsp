<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	String str = "안녕하세요!";
	int a =5, b=-5;
	
	public int abs(int n){
		if(n<0){
			n = -n;
		}
		return n;
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
JSP로 작성.<br>
<%
	out.print(str+"<br>");
	out.print(a+"의 절대값 : "+ abs(a) +"<br>");
	out.print(b+"의 절대값 : "+ abs(b) +"<br>");
%>
<br> 
서블릿 스타일로 작성.<br>
<%= str %><br>
<%=a %>의 절대값 : <%= abs(a) %><br>
<%=b %>의 절대값 : <%= abs(b) %><br>

<%
	Calendar date=Calendar.getInstance();
	SimpleDateFormat today = new SimpleDateFormat("yyyy년 MM월 DD일");
	SimpleDateFormat now = new SimpleDateFormat("hh시 mm분 ss초");
%>

오늘은 <b> <%= today.format(date.getTime()) %></b> 입니다. <br>
지금 시각은 <b> <%= now.format(date.getTime()) %></b> 입니다.

</body>
</html>