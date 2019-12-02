<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/w3.css">
<script type ="text/javascript" src="/js/jquery-3.4.1.min.js">
</script>
<style>
</style>
<script type="text/javascript">
$(document).ready(function () {
	$('#list').click(function () {
		$(location).attr('href', "/board/boardlist.cls");
	});
$('#join').click(function () {
	var wr = $('.wri').attr('id');
	alert(wr);
});
});
</script>
</head>
<body>
	<form method="POST" action="/board/boardwriteproc.cls">
	<div class="w3-col m3">
		<p></p>
	</div>
	<div class="w3-col m6 w3-center">
		<h2 class="w3-col w3-padding w3-blue w3-margin-bottom">글쓰기</h2>
		<div class="w3-col w3-padding w3-margin-bottom">
			<div class="w3-row w3-border">
				<input type="hidden" id="id" name="id" value="${SID}"> 
				
				<div class="w3-col m2 w3-board-right">제목</div>
				<div class="w3-col m10 w3-board-right"><input type="text" class="w3-col" id="fbname" name="fbname"></div>
				
			</div>
		<div class="w3-col w3-padding w3-margin-bottom">
				<div><textarea cols="150" rows="20" id="fbbody" name="fbbody" class="w3-col  w3-board-right"></textarea></div>
				
			</div>
		
			<div class="w3-col m2 w3-button w3-blue" id="list">리스트</div>
		
			<input class="w3-col m2 w3-button w3-right w3-red" type="submit" id="join" name="join" value="저장"></div>
			<input type="hidden" class="wri" id="${cnt}"> 
		</div>
	</form>
</body>
</html>