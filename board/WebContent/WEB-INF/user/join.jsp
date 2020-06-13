<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#msg{color:red}
</style>

</head>
<body>
	<h2>회원가입</h2>
	<form action="/join.do" method="post">
		<input type="text" name="id" placeholder="id" value="${id }"><br>
		<input type="password" name="pw" placeholder="pw"><br>
		<input type="text" name="name" placeholder="이름"><br>
		<input type="submit" value="가입">
	</form>
	<p id="msg">${msg }</p>
</body>
</html>