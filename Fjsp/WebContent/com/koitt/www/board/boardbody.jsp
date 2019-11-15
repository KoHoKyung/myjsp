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
</script>
</head>
<body>
	<div class="w3-col m3">
		<p></p>
	</div>
	<div class="w3-col m6 w3-center">
		<h2 class="w3-col w3-padding w3-blue w3-margin-bottom">글내용</h2>
		<div class="w3-col w3-padding w3-margin-bottom">
			<div class="w3-row w3-border">
				<!-- 글번호 | 작성자 | 작성일 | 타이틀 -->
				<div class="w3-col m2 w3-board-right">글번호</div>
				<div class="w3-col m2 w3-board-right">작성자</div>
				<div class="w3-col m2 w3-board-right">작성일</div>
				<div class="w3-col m6 ">타이틀</div>
			</div>

				<c:forEach var="data" items= "${list}">
			<div class="w3-row w3-border so" id="${data.fb_no}">
			
				<!-- 글번호 | 작성자 | 작성일 | 타이틀 -->
				<div class="w3-col m2 w3-board-right">${data.fb_no}</div>
				<div class="w3-col m2 w3-board-right">${data.fb_id}</div>
				<div class="w3-col m2 w3-board-right">${data.wdate}</div>
				<div class="w3-col m6 ">${data.fb_title}</div>
			</div>
			</c:forEach>
			</div>
		
			<div class="w3-col m2 w3-button w3-blue" id="main">홈으로</div>
			<c:if test='${empty SID }'>
			<div class="w3-col m2 w3-button w3-blue" id="login">로그인</div>
			</c:if>
			<c:if test='${not empty SID }'>
			<div class="w3-col m2 w3-button w3-right w3-red" id="writer">글쓰기</div>
			</c:if>
		</div>
	</div>
</body>
</html>