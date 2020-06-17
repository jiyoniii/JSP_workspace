<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 고전적인 방식 -->
<h3>고전방식</h3>
아이디 : 	<%=request.getParameter("id")%><br>
비밀번호 : <%=request.getParameter("pwd")%><br>

<!-- EL방식 -->
<h3>EL방식</h3>
아이디 : 	${param.id}<br>
비밀번호 : ${param.pwd}<br>
