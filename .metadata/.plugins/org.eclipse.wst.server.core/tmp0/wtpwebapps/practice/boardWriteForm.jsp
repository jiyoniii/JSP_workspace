<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form name="form" method="post" action="boardWrite.jsp" style="max-width:500px;margin-top: 100px;">
	
		<div>
            <input class="input-field" type="text" placeholder="작성자" name="name"><br>
        </div>
        <div>
            <input class="input-field" type="text" placeholder="비밀번호" name="pass"></input>
        </div>
        <div>
            <input class="input-field" type="text" placeholder="이메일" name="email"></input>
        </div>
        <div>
            <input class="input-field" type="text" placeholder="글 제목" name="title"></input>
        </div>
        <div>
            <input class="input-field" type="text" placeholder="글 내용" name="content"></input>
        </div>
        <!-- <button type="submit" value="동의하고 가입하기">동의하고 가입하기</button> -->
        <button type="submit" value="등록">등록</button>

    </form>
</body>
</html>