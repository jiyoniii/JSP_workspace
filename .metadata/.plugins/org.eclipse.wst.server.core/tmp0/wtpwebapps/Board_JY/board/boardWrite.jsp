<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="wrap" align="center">

		<h1>게시글 등록</h1>
		
		<form name="frm" method="post" action="BoardServlet">
		
			<!-- command방식으로 처리하기 때문에 히든태그로 command의 파라미터를 서블릿에 전달 -->
			<input type="hidden" name="command" value="board_write">
			<table>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="name"> * 필수</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pass"> * 필수 (게시물 수정
						삭제시 필요합니다.)</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" size="70" name="title"> * 필수</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea cols="70" rows="15" name="content"></textarea></td>
				</tr>
			</table>
			<br>
			<br> <input type="submit" value="등록"
				onclick="return boardCheck()"> <input type="reset"
				value="다시 작성"> <input type="button" value="목록"
				onclick="location.href='BoardServlet?command=board_list'">
		</form>
	</div>
</body>
</html>