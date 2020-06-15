<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 상세 페이지</title>
</head>
<body>
	 
	
	<h2>${one.pk}번 게시물</h2>
	<form action="/write" method="post" id="frm" onsubmit="return chk()">
		<div><input type="text" name="title" value="제목 : ${one.title }" readonly></div>
		<div><input type="text" name="hits" value ="조회수 : ${one.hits }" readonly></div>
		<div><input type="text" name="name" value="글쓴이 : ${one.name }" readonly></div>
		<div><textarea rows="10" cols="22" name="content" readonly >${one.content } </textarea></div>	
	</form>
	
	<h3>댓글</h3>
	
	<c:forEach items="${commentAll }" var="commentVO">
	<textarea rows="1" cols="50"  readonly>작성자 : ${commentVO.name}</textarea><br>
	<textarea rows="4" cols="50"  readonly>${commentVO.com_content }</textarea><br><br><br>
	</c:forEach>
	
	
	<h3>댓글작성</h3>
	<form method="post" action="/board/comment">
		<textarea rows="4" cols="50" name="com_content"></textarea>
		<input type="hidden" name="user_pk" value="${loginUser.pk }">
		<input type="hidden" name="board_pk" value="${one.pk }">
		<input type="submit" value="댓글작성">
	</form>
	
	


	
</body>
</html>