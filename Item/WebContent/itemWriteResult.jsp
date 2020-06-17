<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

<h3>등록한 내용</h3>
등록한 제품의 이름은 ${inputName.name}, 가격은 ${inputName.price}, 제품 설명은 ${inputName.description} 입니다.

</body>
</html>