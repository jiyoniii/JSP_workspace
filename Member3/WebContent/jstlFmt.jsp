<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--날짜 표기방식 중요함!! -->
	<c:set var="now" value="<%=new java.util.Date()%>"></c:set>
	\${now} : ${now} <br>
	<fmt:formatDate value="${now}" pattern="yyyy년MM월dd일"/>
	<br>
	<fmt:formatNumber value="100000" type="currency" />
	
	<br>
	<fmt:setLocale value="en_US" />
	<fmt:formatNumber value="100000" type="currency" />
</body>
</html>