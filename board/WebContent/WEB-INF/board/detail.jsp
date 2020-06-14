<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 
	
	<h2>${one.pk}번 게시물</h2>
	<form action="/write" method="post" id="frm" onsubmit="return chk()">
		<div><input type="text" name="title" value="제목 : ${one.title }" readonly></div>
		<div><input type="text" name="hits" value ="조회수 : ${one.hits }" readonly></div>
		<div><input type="text" name="name" value="글쓴이 : ${one.name }" readonly></div>
		<div><textarea rows="10" cols="22" name="content" readonly >${one.content } </textarea></div>	
	</form>


	
</body>
</html>