<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
</head>
<body>
		<div id="wrap" align="center">
		<h1>게시글 리스트</h1>
		<table class="list">
			<tr>
				<!-- border white로 해서 투명한 테두리로 만들게 됨 -->
				<td colspan="5" style="border: white; text-align: right"><a
					href="BoardServlet?command=board_write_form">게시글 등록</a></td>
			</tr>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회</th>
			</tr>
			<!-- 목록이라 JSTL인 forEach로 처리 -->
			<!-- board라는 변수를 세워두고 record 클래스가 계속 반복적으로 돌아가게 함으로써 리스트를 생성해냄 -->
			<c:forEach var="board" items="${boardList }"><!-- {} 는 Attribute로 받은것! -->
				<tr class="record">
					<td>${board.num }</td>
					<td><a href="BoardServlet?command=board_view&num=${board.num}">
							${board.title } </a></td>
					<td>${board.name}</td>
					<td><fmt:formatDate value="${board.writedate }" /></td>
					<td>${board.readcount}</td>
				</tr>
			</c:forEach>
		</table>
	</div>


</body>
</html>