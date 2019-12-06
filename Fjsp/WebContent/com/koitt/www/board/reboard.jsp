<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/w3.css">
<script type="text/javascript" src="/js/jquery-3.4.1.min.js">
	
</script>
<style>
.w90 {
	display: inline-block;
	width: 90px;
}

.w80 {
	width: 80px;
}
</style>
<script type="text/javascript">
	$(function() {
		/* $('#login').click(function () {
			$(location).attr('href', '/member/login.cls');
		});
		$('#home').click(function () {
			$(location).attr('href', '/');
		});
		$('#logout').click(function () {
			$(location).attr('href', '/member/logout.cls');
		}); */

		$('.w3-button').click(function() {
			var tid = $(this).attr('id');
			var target = '';
			if (tid == 'login') {
				target = '/member/login.cls';
			} else if (tid == 'logout') {
				target = '/member/logout.cls';
			} else if (tid == 'home') {
				target = '/';
			} else if (tid == 'write') {
				target = '/board/reboardWrite.cls';
			}
			$(location).attr('href', target);
		});
		
	$('.pbutton').click(function () {
		var sPage = $(this).text();
		var sp = $('#startbtn').html();
		var rp = $('#endbtn').html();
		alert(sp);
		if(sPage != sp || sPage != rp){
			$('#nowPage').val(sPage);

		}
		if(sPage == sp){
			if('${PAGE.startPage}' == 1){
				return;
			}
			sPage = '${PAGE.startPage - 1}';
			$('#nowPage').val(sPage);

		}
		if(sPage == rp){
			if('${PAGE.endPage}' == '${PAGE.totalPage}'){
				return;
			}
			sPage = '$(PAGE.endPage + 1)';
			$('#nowPage').val(sPage);
		}
			$('#frm').submit();
	});
	
	});
</script>
</head>
<body>
	<form method="post" action="/board/reboard.cls" id="frm">
		<input type="hidden" name="nowPage" id="nowPage">
	<div class="w3-col m3">
		<p></p>
	</div>
	<div class="w3-col m6">
		<h2 class="w3-container w3-margin-top w3-purple w3-card">댓글 게시판</h2>
		<div>
			<div class="w3-button w3-midium w3-green w3-left" id="home">home</div>
			<c:if test="${empty SID }">
				<div class="w3-button w3-midium w3-lime w3-left" id="login">login</div>
			</c:if>
			<c:if test="${not empty SID }">
				<div class="w3-button w3-midium w3-green w3-left" id="logout">logout</div>
				<div class="w3-button w3-midium w3-green w3-right" id="write">글쓰기</div>
			</c:if>
		</div>

		<div class="w3-col w3-container w3-margin-top">
			<c:forEach var="data" items="${LIST}">
				<div style="padding-left: ${data.lvl * 50}px; margin-top:10px;">
					<div class="w3-container w3-card">
						<div class="w3-col w90 w3-center">
							<div class="w3-content w3-circle">
								<img src="/img/avatar/${data.avatar}" class="w80 w3-circle">
							</div>
							<h6>${data.id}</h6>
						</div>
						<div class="w3-rest lpad25">
							<h6 class="w3-col m3">${data.wDate}<small>${data.wTime }</small>
							</h6>
							<div class="w3-col m9 w3-padding">
								<c:if test="${data.id eq SID}">
									<button class="w3-button w3-tiny w3-red w3-right">삭제</button>
									<button class="w3-button w3-tiny w3-red w3-right">수정</button>
								</c:if>
								<c:if test="${not empty SID}">
									<button class="w3-button w3-tiny w3-red w3-right">댓글</button>
								</c:if>
							</div>

							<hr class="w3-col" style="margin-top: 0px;">
							<div class="w3-container">${data.body}</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="w3-center">
			<div class="w3-bar w3-border w3-margin-top w3-margin-bottom">
				  <div class="w3-bar-item w3-button w3-hover-blue pbutton " id="startbtn">&laquo;</div>
				
				 <c:forEach var="page" begin="${PAGE.startPage}" end="${PAGE.endPage}">
					  <div class="w3-bar-item w3-button w3-hover-blue pbutton">${page}</div>
				</c:forEach>
				<div class="w3-bar-item w3-button w3-hover-blue pbutton" id="endbtn">&raquo;</div>
			

			</div>
		</div>
	</div>
</form>
</body>
</html>