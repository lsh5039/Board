<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>


<style>
	table,tr,td,th{border:1px solid #333; border-collapse:collapse; cursor:pointer; text-align:center;}
	tr:hover{background-color:#f4f4f4;}
</style>



</head>
<body>
	<h2>글 목록</h2>
	<table>
		<tr>
			<th>게시번호</th>
			<th>제목</th>
			
			<th>조회수</th>
		</tr>
		
		
		<c:forEach items="${list }" var="vo">
		<tr onclick="goDetail(${vo.pk })">
			<td>${vo.pk }</td>
			<td>${vo.title }</td>
			
			<td>${vo.hits }</td>
		</tr>
		
		</c:forEach>
	</table>
	<a href="/write">글 쓰기</a>
	
	<script>
		function goDetail(pk){
			location.href="/board/detail?pk="+pk;//js에서 get방식으로 보내기!
		}
	
	</script>
	

</body>
</html>