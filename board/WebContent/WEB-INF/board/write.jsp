<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
<style>
.msg{color:red;}
</style>
</head>
<body>
	<h2>글 작성</h2>
	<form action="/write" method="post" id="frm" onsubmit="return chk()">
		<div><input type="text" name="title" placeholder="제목"></div>
		<div><textarea rows="10" cols="22" name="content" placeholder="내용"></textarea></div>	
		<div><input type="submit" value="글작성"></div>
	</form>
	<p class="msg" id="msg">${msg }</p>
	
	
	<script>
		function chk(){
			if(frm.title.value==""){
				msg.innerHTML = "제목을 입력하세요"
				frm.title.focus();
				return false;
			} else if(frm.content.value==""){
				msg.innerHTML = "내용을 입력하세요"
					frm.content.focus();
				return false;
			}
		}
	
	
	</script>
</body>
</html>