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
::placeholder {
	color: pink;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$('#main').click(function() {
			$(location).attr('href', '/board/boardlist.cls');
		});
		$('.reset').click(function() {

			$('.main1').css('display', 'none');

			$('.main2').css('display', 'block');
		});
		$('#list2').click(function() {
			$('.main1').css('display', 'block');

			$('.main2').css('display', 'none');
		});
		$('#mno').click(function () {
			var ss = $('.cnt').attr('id');
			if(ss == "1"){
				alert("수정완료");
			}else {
				alert("수정실패");
			}
			
			$('.main1').css('display', 'block');

			$('.main2').css('display', 'none');
		});

		});

</script>
</head>
<body class="w3-teal " style="background: url('/img/avatar/1324.gif')">
	<div class="w3-col m3">
		<p></p>
	</div>
	<div class="w3-col m6 w3-center main1 w3-pale-blue">
		<c:forEach var="da" items="${body}">
			<h2 class="w3-col w3-padding w3-blue w3-margin-bottom">글내용</h2>
			<div class="w3-col w3-padding w3-margin-bottom">


				<div class="w3-row w3-border w3-white">


					<div class="w3-col m2 w3-board-right w3-gray w3-padding-16">ID
					</div>
					<div class="w3-col m2 w3-board-right w3-center  w3-padding-16">${da.fb_id}</div>
					<div class="w3-col m2 w3-board-right w3-right  w3-padding-16">${da.wdate}</div>
					<div
						class="w3-col m2 w3-board-right w3-right w3-gray  w3-padding-16">입력날짜
						</div>

				</div>
				<div class="w3-row w3-border w3-white">

					<!-- 글번호 | 작성자 | 작성일 | 타이틀 -->
					<div class="w3-col m2 w3-bodycolor-red w3-padding-16 w3-gray">제목
					</div>
					<div class="w3-col m8 w3-board-right w3-padding-16" id="fbname">${da.fb_title}</div>
				</div>

				<div class="w3-row w3-border w3-white">

					<!-- 글번호 | 작성자 | 작성일 | 타이틀 -->
					<div class="w3-col  w3-padding-16 w3-pale-blue">내 용</div>
				</div>
				<div class="w3-col w3-border w3-white" style="height: 400px;">

					<!-- 글번호 | 작성자 | 작성일 | 타이틀 -->
					<pre class="w3-col w3-left w3-xlarge w3-left-align " id="fbbody">${da.fb_body}</pre>
				</div>
				<form method="POST" action="/board/boardre.cls">
					<div class="w3-con w3-border">
						<textarea class="w3-dark-grey w3-col" rows="5" cols="100"
							placeholder="댓글을 입력하세요" id="rep" name="rep"></textarea>
						<input type="hidden" name="fbno" value="${da.fb_no}" >
						<input type="hidden" name="sid" value="${SID}" >
						<button class="w3-right w3-button w3-green">입력완료</button>
					</div>
				</form>
			</div>
			<div class="w3-left" style="font-size: 20px; margin-bottom: 20px; margin-left: 20px;">댓 글</div>
				<c:forEach var="com" items="${list}">
				
			<div class="w3-container w3-white">
			<div class="w3-row w3-border w3-margin-bottom">
					<div class="w3-col m2 w3-border-right w3-padding-16 w3-blue" id="id${da.fb_no}">${com.frb_id} </div>
					<div class="w3-col m2 w3-border-right  w3-teal" style="padding: 5px;" >${com.sdate}<small>${com.stime}</small></div>
					<div class="w3-col m7 w3-border-right w3-center w3-padding-16 w3-white" id="bd${da.fb_no}">${com.frb_body}</div>
				<form method="POST" action="/board/boardredel.cls">
					<c:if test='${not empty SID }'>
					<c:if test='${SID == com.frb_id}'>
					
						<button class="w3-col m1 w3-button w3-padding-16 w3-red" type="submit" name="bno" value="${com.frb_bno }">삭제</button>
						<input type="hidden" name="fbno" value="${da.fb_no}">
					</c:if>
				</c:if>
					<c:if test='${not empty SID }'>
					<c:if test="${SID eq '관리자'}">
					
						<button class="w3-col m1 w3-button w3-padding-16 w3-red" type="submit" name="bno" value="${com.frb_bno }">삭제</button>
						<input type="hidden" name="fbno" value="${da.fb_no}">
					</c:if>
				</c:if>
				</form>	
				</div>
				</div>
				</c:forEach>

			<div class="w3-col m2 w3-button w3-black w3-right" id="main">목록</div>
			<form method="POST" action="/board/boarddelete.cls">
				<c:if test='${not empty SID}'>
					<c:if test='${SID == da.fb_id }'>
						<button class="w3-col m2 w3-button w3-padding w3-right w3-red del"
							type="submit" id="fbno" name="fbno" value="${da.fb_no}">삭제하기</button>
					</c:if>
					<c:if test='${SID == "관리자" }'>
						<button class="w3-col m2 w3-button w3-padding w3-right w3-red del"
							type="submit" id="fbno" name="fbno" value="${da.fb_no}">삭제하기</button>
					</c:if>
					<div class="w3-col m2 w3-button w3-right w3-blue reset">수정하기</div>
				</c:if>
			</form>
		</c:forEach>
	</div>


	<!-- ------------------------------------------------수정하기 --------------------------------------------------- -->
	<form method="POST" action="/board/boardreset.cls">
	<c:forEach var="da" items="${body}">
		<div class="w3-col m6 w3-center main2 w3-pale-blue" style="display: none">
			<h2 class="w3-col w3-padding w3-blue w3-margin-bottom">글내용</h2>
			<div class="w3-col w3-padding w3-margin-bottom">

				<div class="w3-row w3-border w3-white">

					<div class="w3-col m2 w3-board-right w3-gray  w3-padding-16">ID
					</div>
					<div class="w3-col m2 w3-board-right  w3-padding-16">${da.fb_id}</div>
					<div class="w3-col m2 w3-board-right w3-right  w3-padding-16">${da.wdate}</div>
					<div
						class="w3-col m2 w3-board-right w3-right w3-gray  w3-padding-16">입력날짜
					</div>

				</div>
				<div class="w3-row w3-border  w3-white">

					<!-- 글번호 | 작성자 | 작성일 | 타이틀 -->
					<div class="w3-col m2 w3-bodycolor-red w3-padding-16 w3-gray">제목
					</div>
					<div class="w3-col m8 w3-board-right w3-padding-16">${da.fb_title}</div>
				</div>

				<div class="w3-row w3-border  w3-white">

					<!-- 글번호 | 작성자 | 작성일 | 타이틀 -->
					<div class="w3-col  w3-padding-16 w3-pale-blue">내 용</div>
					<div class="w3-col w3-padding w3-margin-bottom">
						<div>
							<textarea cols="150" rows="20" id="fbb" name="fbb"
								class="w3-col  w3-board-right"></textarea>
						</div>
					</div>
				</div>
			</div>


			<div class="w3-col m2 w3-button w3-red w3-right" id="list2">취소</div>
		

				<c:if test='${not empty SID }'>
		
					<button class="w3-col m2 w3-button w3-right w3-blue writer"
						id="mno" name="mno" value="${da.fb_no }">수정완료</button>
					<input type="hidden" class="cnt" id="${cnt}">
				</c:if>




		</div>
	</c:forEach>
			</form>
</body>
</html>