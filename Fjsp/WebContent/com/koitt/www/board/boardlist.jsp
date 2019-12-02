<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/w3.css">
<script type="text/javascript" src="/js/jquery-3.4.1.min.js"></script>
<style>
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$('#main').click(function() {
			$(location).attr('href', '/main');
		});
		$('#login').click(function() {
			$(location).attr('href', '/member/login.cls');
		});
		$('#writer').click(function() {
			$(location).attr('href', '/board/boardwrite.cls');
		});

		$('.so').click(function() {
			var sid = $(this).attr('id');
			$(location).attr('href', '/board/boardclick.cls?sid=' + sid);
		});
		$('#join').click(function() {
			$(location).attr('href', '/member/joinform.cls');
		});
		$('.cs').click(function() {
			var pN = $(this).attr('id');

		});
	});
</script>
</head>
<body class="w3-sand">
	<div class="w3-col m3"><p></p></div>
	<div class="w3-col m6 w3-center w3-white">
		<h2 class="w3-col w3-padding w3-blue w3-margin-bottom">파일 업로드</h2>
		<form method="POST" action="/board/boardlist.cls">
			<button class="w3-button w3-blue w3-right"
				style="margin-right: 15px;" type="submit">검색하기</button>
			<input class="w3-right" type="text"
				style="padding-top: 10px; margin-right: 5px;" id="st" name="st">
			<select class="w3-right" style="padding: 7px; margin-right: 5px;"
				name="select">
				<option value="1" selected="selected">제목</option>
				<option value="2">작성자</option>
				<option value="3">내용</option>
				<option value="4">제목+내용</option>
			</select>
		</form>
		<div class="w3-col w3-padding w3-margin-bottom ">
			<div class="w3-row w3-border w3-green">
				<!-- 글번호 | 작성자 | 작성일 | 타이틀 -->
				<div class="w3-col m2 w3-board-right w3-padding-16">글번호</div>
				<div class="w3-col m2 w3-board-right w3-padding-16 ">작성자</div>
				<div class="w3-col m2 w3-board-right w3-margin-left w3-padding-16">작성일</div>
				<div class="w3-col m5 w3-padding-16">제목</div>
			</div>

			<c:forEach var="data" items="${LIST}">
				<div class="w3-row w3-border so " id="${data.fb_no}">
					<div class="w3-col w3-button w3-sand">
						<!-- 글번호 | 작성자 | 작성일 | 타이틀 -->
						<div class="w3-col m1 w3-board-right w3-margin-left">${data.fb_rn}</div>
						<div class="w3-col m3 w3-board-right">${data.fb_id}</div>
						<div class="w3-col m2 w3-board-right">${data.wdate}</div>
						<div class="w3-col m5 w3-center ">${data.fb_title}</div>
					</div>
				</div>
			</c:forEach>
			<div>
				<div>
					<c:if test='${not empty st && not empty sel }'>
						<c:if test='${ startPage > 1 }'>
							<a href="/board/boardlist.cls?pageNum=${startPage - 1}&st=${st}&select=${sel}"><button>◀</button></a>
						</c:if>
						<c:if test='${ cur > 1 }'>
							<a href="/board/boardlist.cls?pageNum=${cur - 1}&st=${st}&select=${sel}"><button>◁</button></a>
						</c:if>
						<c:forEach var="num" begin="${ startPage }" end="${ endPage +1}">
							<span><a href="/board/boardlist.cls?pageNum=${num}&st=${st}&select=${sel}">${num}</a></span>
						</c:forEach>
						<!-- 다음 페이지 그룹이 존재 -->
						<c:if test='${ endPage +1 > cur}'>
							<a href="/board/boardlist.cls?pageNum=${cur + 1}&st=${st}&select=${sel}"><button>▷</button></a>
						</c:if>
						<c:if test='${ totalPage < endPage +1}'>
							<a href="/board/boardlist.cls?pageNum=${endPage + 1}&st=${st}&select=${sel}"><button>▶</button></a>
						</c:if>
					</c:if>
					<c:if test='${empty st && empty sel }'>
						<c:if test='${ startPage > 1 }'>
							<a href="/board/boardlist.cls?pageNum=${startPage -1}"><button>◀</button></a>
						</c:if>
						<c:if test='${ cur > 1 }'>
							<a href="/board/boardlist.cls?pageNum=${cur - 1}"><button>◁</button></a>
						</c:if>
						<c:forEach var="num" begin="${ startPage }" end="${ endPage }">
							<span><a href="/board/boardlist.cls?pageNum=${num}">${num}</a></span>
						</c:forEach>
						<!-- 다음 페이지 그룹이 존재 -->
						<c:if test='${ endPage  > cur}'>
							<a href="/board/boardlist.cls?pageNum=${cur + 1}"><button>▷</button></a>
						</c:if>
						<c:if test='${ totalPage < endPage  }'>
							<a href="/board/boardlist.cls?pageNum=${endPage + 1}"><button>▶</button></a>
						</c:if>
					</c:if>
				</div>
			</div>
			<div class="w3-col m2 w3-button w3-blue" id="main">홈으로</div>

			<c:if test='${empty SID }'>
				<div class="w3-col m2 w3-button w3-red" id="login">로그인</div>
				<div class="w3-col m2 w3-button w3-deep-purple" id="join">회원가입</div>
			</c:if>
			<c:if test='${not empty SID }'>
				<div class="w3-col m2 w3-button w3-right w3-red" id="writer">글쓰기</div>
			</c:if>

		</div>
	</div>
</body>
</html>