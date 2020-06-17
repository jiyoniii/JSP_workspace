<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel = "stylesheet" type="text/css" href="css/shopping.css">
<script type="text/javascript" src = "script/board.js"></script>
</head>
<body>
	<div id="wrap" align="center">
		<h1>게시글 등록</h1>
		<form name="frm" method="post" action="BoardServlet">
			<input type="hidden" name="command" value="board_write">
			<table>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="name"> *필수</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pass"> *필수</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" size="70" name="title"> *필수</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea cols="70" rows="15" name="content"></textarea></td>
				</tr>
			</table>
			<br>
			<br> 
			<input type="submit" class="btn btn-sm btn-primary" value="등록" onclick="return boardCheck()">
			<input type="button"  class="btn btn-sm btn-primary" value="목록" onclick="location.href='BoardServlet?command=board_list'">	
		</form>
		
	
	
	</div>





</body>
</html>