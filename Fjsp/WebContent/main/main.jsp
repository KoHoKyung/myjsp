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
</style>
<script type="text/javascript">
$(document).ready( function () {
	$('#login').click(function () {
		$(location).attr('href', '/member/login.cls');
	})
	$('#logout').click(function () {
		$(location).attr('href', '/member/logout.cls');
	});
	$('#join').click(function () {
		$(location).attr('href', '/member/joinform.cls');
	});
	$('#boardlist').click(function () {
		$(location).attr('href', '/board/boardlist.cls');
	});

	$('#list').click(function() {
		// 회원번호를 mt3 클래스가 적용된 태그에 아이디 값으로 입력해놨으므로
		// 해당태그의 아이디 값을 읽어온다.
		var tid = '${SID}';
		alert(tid);
		// 이제 화면 전체가 리로드 되어야 하는 것이 아니고
		// detail 아이디가 부여된 태그에만 적용이 되어야 하므로
		// 비동기 통신으로 데이터를 받아서
		// 해당 태그에 적용시켜주면된다.
		
		$.ajax({
			url : "/member/memberInfo.ck",
			type : "POST",
			dataType : "json",
			data : {
				mid : tid
			},
			success : function (data) {
				$('#mno').html(data.m_no);
				$('#mid').html(data.m_id);
				$('#mname').html(data.m_name);
				$('#mmail').html(data.m_mail);
				$('#mtel').html(data.m_tel);
				$('#mdate').html(data.m_join);
				$('#detail').css('display', 'block');
				
				$('#infoEdit').click(function name() {
				$('#no').html(data.m_no);
				$('#id').html(data.m_id);
				$('#name').html(data.m_name);
				$('#mail').val(data.m_mail);
				$('#tel').val(data.m_tel);
				$('#date').html(data.m_join);
				$('#detail').css('display', 'none');
				$('#edit').css('display', 'block');
				
					
				});
			},
			error : function () {
				
				alert('### 통신 에러 ###');
			}
		});
	});
	
	$('#btn2').click(function () {
		$('#detail').css('display', 'none');
	});
	
	$('#btn3').click(function () {
		$('#edit').css('display', 'none');
	});
	$('#save').click(function () {
		// 할일
	// 데이터 읽어오고
		var no = $('#no').text();
		var mail1 = $('#mmail').text();
		var mail2 = $('#mail').val();
		var tel1 = $('#mtel').text();
		var tel2 = $('#tel').val();
		var code = 1;
		if(mail1 == mail2 && tel1 == tel2){
			return;
		} else if(mail1 == mail2){
			// 전화번호만 수정한 경우
			code = 3;
		} else if(tel1 == tel2){
			// 메일만 수정한 경우
			code = 2;
		} else{
			// 둘다 수정한 경우
			code = 1;
		}
		$.ajax({
			url : "/member/infoEdit.ck",
			type : "POST",
			dataType : "json",
			data : {
				"mno"  : no,
				"mail" : mail2,
				"tel"  : tel2,
				"code" : code
			},
			success : function (data) {
				if(data.cnt == 1){
					$('#edit').css('display', 'none');
					alert("수정 완료");
				} else{
					alert("수정 실패")
				}
			},
			error : function () {
				alert("서버 오류");
			}
		}); 
	});
/* 	$('#userEdit').click(function () {
		$('edit').css('display', 'block');
	}) */
	$('#close').click(function () {
		$('#detail').css('display', 'none');
	});
	$('#cancel').click(function () {
		$('#edit').css('display', 'none');
	});
});


</script>
</head>
<body>

   <div class="w3-col m2"><p></p></div>
   <div class="w3-col m8 w3-center w3-margin-top">
      <h1 class="w3-col w3-pale-blue">Welcome My Home!!!</h1>
      <div class="w3-col">
			<c:if test='${empty SID }'>
				<div class="w3-col m2 w3-red w3-button" id="login">로그인</div>
				<div class="w3-col m2 w3-deep-purple w3-button" id="join">회원가입</div>
				<div class="w3-col m2 w3-blue w3-button" id="boardlist">게시판</div>
			</c:if>
			<c:if test='${not empty SID }'>
         <div class="w3-col m2 w3-red w3-button" id="logout">로그아웃</div>
         <div class="w3-col m2 w3-blue w3-button" id="list">회원정보보기</div>
         <div class="w3-col m2 w3-blue w3-button" id="boardlist">게시판</div>
<!--          <div class="w3-col m2 w3-red w3-button" id="userEdit">회원정보수정</div> -->
         

         </c:if>
      </div>
   </div>
	<!-- 회원 상세정보 보기 -->
	<div class="w3-modal" id="detail">
		<div class="w3-modal-content">
			<div class="w3-container w3-col w3-white w3-padding">
				<span id="btn2"
					class="w3-botton w3-display-topright w3-margin-right w3-margin-top w3-xxlarge">&times;</span>
				<h2 class="w3-col w3-line w3-purple  w3-padding-16 w3-card">회원정보</h2>
				<div class="w3-border-bottom w3-col">
					<h5 class="w3-col m3 w3-right-align">회원번호 :</h5>
					<h5 class="w3-col m9 w3-center" id="mno"></h5>
				</div>
				<div class="w3-border-bottom w3-col">
					<h5 class="w3-col m3 w3-right-align">아이디 :</h5>
					<h5 class="w3-col m9 w3-center" id="mid"></h5>
				</div>
				<div class="w3-border-bottom w3-col">
					<h5 class="w3-col m3 w3-right-align">회원이름 :</h5>
					<h5 class="w3-col m9 w3-center" id="mname"></h5>
				</div>
				<div class="w3-border-bottom w3-col">
					<h5 class="w3-col m3 w3-right-align">이메일 :</h5>
					<h5 class="w3-col m9 w3-center" id="mmail"></h5>
				</div>
				<div class="w3-border-bottom w3-col">
					<h5 class="w3-col m3 w3-right-align">전화번호 :</h5>
					<h5 class="w3-col m9 w3-center" id="mtel"></h5>
				</div>
				<div class="w3-border-bottom w3-col">
					<h5 class="w3-col m3 w3-right-align">가 입 일 :</h5>
					<h5 class="w3-col m9 w3-center" id="mdate"></h5>
				</div>
					<div class="w3-col m1 w3-button w3-red w3-left" id="close">닫기</div>
					<div class="w3-col m1 w3-button w3-blue w3-right " id="infoEdit">수정</div>
			</div>
		</div>
	</div>
	<!-- 회원 정보 수정 모달 -->
	<div class="w3-modal" id="edit">
		<div class="w3-modal-content">
			<div class="w3-container w3-col w3-white w3-padding">
				<span id="btn3"
					class="w3-botton w3-display-topright w3-margin-right w3-margin-top w3-xxlarge">&times;</span>
				<h2 class="w3-col w3-line w3-purple  w3-padding-16 w3-card">회원 정보 수정</h2>
				<div class="w3-border-bottom w3-col">
					<h5 class="w3-col m3 w3-right-align">회원번호 :</h5>
					<h5 class="w3-col m9 w3-center" id="no"></h5>
				</div>
				<div class="w3-border-bottom w3-col">
					<h5 class="w3-col m3 w3-right-align">아이디 :</h5>
					<h5 class="w3-col m9 w3-center" id="id"></h5>
				</div>
				<div class="w3-border-bottom w3-col">
					<h5 class="w3-col m3 w3-right-align">회원이름 :</h5>
					<h5 class="w3-col m9 w3-center" id="name"></h5>
				</div>
				<div class="w3-border-bottom w3-col">
					<h5 class="w3-col m3 w3-right-align">이메일 :</h5>
					<h5 class="w3-col m9"><input type="text" class="w3-input w3-border" id="mail" name="mail"></h5>
				</div>
				<div class="w3-border-bottom w3-col">
					<h5 class="w3-col m3 w3-right-align">전화번호 :</h5>
					<h5 class="w3-col m9" ><input type="text" class="w3-input w3-border" id="tel" name="tel"></h5>
				</div>
				<div class="w3-border-bottom w3-col">
					<h5 class="w3-col m3 w3-right-align">가 입 일 :</h5>
					<h5 class="w3-col m9 w3-center" id="date"></h5>
				</div>
				<div class ="w3-col w3-center">
					<div class="w3-col m1 w3-button w3-red" id="cancel">취소</div>
					<div class="w3-col m1 w3-button w3-blue" id="save">저장</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>