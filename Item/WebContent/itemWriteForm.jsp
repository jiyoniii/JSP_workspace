<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>정보입력 폼</h2>
	<form name="frm" method="post" action="itemWriteForm.do">
		
		<input type="text" name="name" placeholder="상품명" >
		<br> 
		
		<input type="text" name="price" placeholder="가격">
		<br> 
		
		<textarea  name="description" placeholder="상품 설명" rows="3" cols="40"></textarea>
		<br>	
		
		<input type="submit" value="등록">&nbsp;
		<input type="reset" value="취소">&nbsp; 
	</form>


</body>
</html>