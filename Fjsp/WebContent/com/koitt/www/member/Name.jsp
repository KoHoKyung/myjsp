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
.mt3 {
	margin-top: 3px;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$('.mt3').click(function() {
			// 회원번호를 mt3 클래스가 적용된 태그에 아이디 값으로 입력해놨으므로
			// 해당태그의 아이디 값을 읽어온다.
			var mid1 = $(this).attr('id');
			
			// 이제 화면 전체가 리로드 되어야 하는 것이 아니고
			// detail 아이디가 부여된 태그에만 적용이 되어야 하므로
			// 비동기 통신으로 데이터를 받아서
			// 해당 태그에 적용시켜주면된다.
			
			$.ajax({
				url : "/member/nameDetail.nop",
				type : "POST",
				dataType : "json",
				data : {
					mid : mid1
				},
				success : function (data) {
					$('#mno').html(data.mno);
					$('#mid').html(data.mid);
					$('#mname').html(data.mname);
					$('#mmail').html(data.mmail);
					$('#mtel').html(data.mtel);
					$('#mdate').html(data.mdate);
					$('#detail').css('display', '');
				},
				error : function () {
					
					alert('### 통신 에러 ###');
				}
			});
		});
	});
	
</script>
</head>

<body class="w3-blue-grey">
	<c:if test="${empty SID}">
	<c:redirect url="/member/Login.nop" />
		</c:if>
	<div class="w3-col m3"><p></p></div>
	<div class="w3-col m6 w3-container w3-center w3-padding-bottom">
		<!-- 리스트제목 -->
		<h2 class="w3-lime w3-card">회원 리스트</h2>
		<div class="w3-col s3-margin-top w3-card">
			<div class="w3-border w3-col w3-card">
				<div class="w3-col m3 w3-light-gray w3-border-right">
					<h6>회원 번호</h6>
				</div>
				<div class="w3-col m3 w3-light-gray w3-border-right">
					<h6>회원 이름</h6>
				</div>
				<div class="w3-col m6 w3-light-gray">
					<h6>전화 번호</h6>
				</div>
			</div>

			<c:forEach var="data" items="${LIST}">
				<div class="w3-col s3-margin-top mt3" id="${data.m_No}" >
					<div class="w3-col m3 w3-light-gray w3-border-right w3-hover-blue">
						<h6>${data.m_No}</h6>
					</div>
					<div class="w3-col m3 w3-light-gray w3-border-right w3-hover-blue" >
						<h6>${data.m_Name}</h6>
					</div>
					<div class="w3-col m6 w3-light-gray w3-hover-blue">
						<h6>${data.m_Tel}</h6>
					</div>
					<%--          <div id="${data.m_No}" class="w3-col m2 uname1">${data.m_Name}</div> --%>

				</div>
			</c:forEach>

		</div>
		
		<!-- 회원 상세정보 보기 -->
		<div class="w3-container w3-col w3-card w3-margin-top w3-white" id="detail" style="display: none;">
			<h2 class="w3-col w3-line w3-purple  w3-padding-16 w3-card">회원 정보</h2>
			<div class="w3-border-bottom w3-col">
				<h5 class="w3-col m3">회원번호 :</h5>
				<h5 class="w3-col m9" id="mno"></h5>
			</div>
			<div class="w3-border-bottom w3-col">
				<h5 class="w3-col m3">아이디 :</h5>
				<h5 class="w3-col m9" id="mid"></h5>
			</div>
			<div class="w3-border-bottom w3-col">
				<h5 class="w3-col m3">회원이름 :</h5>
				<h5 class="w3-col m9 " id="mname"></h5>
			</div>
			<div class="w3-border-bottom w3-col">
				<h5 class="w3-col m3">이메일 :</h5>
				<h5 class="w3-col m9" id="mmail"></h5>
			</div>
			<div class="w3-border-bottom w3-col">
				<h5 class="w3-col m3">전화번호 :</h5>
				<h5 class="w3-col m9" id="mtel"></h5>
			</div>
			<div class="w3-border-bottom w3-col">
				<h5 class="w3-col m3">가 입 일 :</h5>
				<h5 class="w3-col m9" id="mdate"></h5>
			</div>

		</div>
			</div>
					<div class = "w3-magin-top w3-right w3-float-right">
			<input type="submit" onclick="location.href='/member/LoginExec.nop';" id="join" name="join" value="Log Out" style="font-size: 25px">
		</div>


</body>
</html>