<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/member.js"></script>
</head>
<body>
	<h2>아이디 중복확인</h2>
	<form action="idCheck.do" method="get" name="frm">
		아이디 <input type=text name="userid" value="${userid}"> 
		<input type=submit value="중복 체크"> <br>
		
		<!-- 아래 result는 DAO에서 가져온 result -->
		<!-- DAO 에서 result에 대한 메소드를 생성 -> servlet에서는 DAO 객체 가져와 setAttribute로  result의 값을 넘겨주고 있었음. -->
		<c:if test="${result == 1}">
			<script type="text/javascript">
				opener.document.frm.userid.value = "";
			</script>
			${userid}는 이미 사용 중인 아이디입니다.
		</c:if>
		<c:if test="${result==-1}">
		${userid}는 사용 가능한 아이디입니다.
		<input type="button" value="사용" class="cancel" onclick="idok()">
		</c:if>
	</form>
</body>
</html>