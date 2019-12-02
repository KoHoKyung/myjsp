<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login Test 1st</title>

<c:if test="${not empty SID}">
   <meta http-equiv="Refresh" content="3; url=/" />
</c:if>

<link rel="stylesheet" href="/css/w3.css" >
<script type="text/javascript" src="/js/jquery-3.4.1.min.js" ></script>
<style>
</style>
<script type="text/javascript">
$(document).ready(function () {
	$('#home').click(function () {
		$(location).attr('href', '/');
	});
});
/*    
   var sid = '${SID}';
   $(function(){
      if(!sid || sid.length != 0){
         $(location).attr('href', '/');
      }
   }); */
</script>
</head>
<body class="w3-teal">
   <div class="w3-col m3"><p></p></div>
   <!-- 로그인 폼 페이지 -->

   <c:if test="${empty SID}">
   
<!--       <form method="POST" action="/member/LoginExec.nop" id="frm"  class="w3-col m6 w3-center w3-margin-top" > -->
      <form method="POST" action="/member/loginProc.cls" id="frm"  class="w3-col m6 w3-center w3-padding-16" style="margin-top : 10%;">
         <button type="button" id="home" class="w3-left w3-indigo w3-button"> 메인화면</button>
      	<div class="w3-col w3-padding-16 w3-green w3-margin-top w3-pale-blue"><h1>로 그 인</h1>
         <div class="w3-col w3-padding-16">
            I D : <input type="text" id="id" name="id" style="width:50%; height: 40px;" placeholder="아이디를 입력하세요">
         </div>
         <div class=" w3-padding-16">
            PW : <input type="password" id="pw" name="pw" style="width:50%; height: 40px;" placeholder="비밀번호를 입력하세요">
         </div>
         
       <button type="submit" id="btn" class="w3-col m6 w3-center w3-padding-16 w3-teal w3-margin-top w3-button" style="margin-left: 27%;">로그인</button>
 
       </div>
      </form>
   </c:if>

   <c:if test="${not empty SID}">
      <div class="w3-col m6 w3-center" id="d1">
         <h3>${SID} 님은 이미로그인 했습니다.</h3>
         <h6>메인 페이지로 이동합니다.</h6>
      </div>
   </c:if>
</body>
</html>