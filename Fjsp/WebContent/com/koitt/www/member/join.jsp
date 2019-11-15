<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
<link rel="stylesheet" href="/css/w3.css" >
<script type="text/javascript" src="/js/jquery-3.4.1.min.js" ></script>
<style>
body {
	background-color: #6DC1F5;
	font-family: calnin
}

.container {
	position: absolute;
	width: 500px;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	color: white;
}

.joinLogo {
	font-size: 40px;
	text-align: center;
}

.ulcl {
	position: relative;
	top: -30px;
	list-style: none;
}

.ulcl input {
	width: 100%;
	height: 15px;
	border: none;
	outline: none;
	background: none;
	border-bottom: 1px dotted white;
}

.pcl {
	position: absolute;
	left: 150px;
	font-size: 10px;
}

li {
	height: 1px;
	font-size: 20px;
	margin: 30px;
	padding: 30px;
}

.inputcl {
	position: relative;
	top: -20px;
	left: 115px;
}

.subcl {
	border: 1px solid white;
	width: 150px;
	height: 50px;
	outline: none;
	background: none;
	color: white;
}

button {
	border: 1px solid white;
	width: 150px;
	height: 50px;
	outline: none;
	background: none;
	color: white;
}
</style>
<script type="text/javascript">
$(function() {
	$('#btn').click(function() {
		var sid = $('#id').val();
		$.ajax({
			url : "/member/idCheck.mmo",
			type : "POST",
			dataType : "json",
			data : {
				'id' : sid
			},
			success : function(data) {
				var ck = data.cnt;
				
				alert(ck);
				if(ck == 1){
					// 이미 회원 가입한 사람이 있는 경우
					$('#id').val("");
					$('#id_check').attr('class', '');
					$('#id_check').toggleClass('w3-text-red');
					$('#id_check').html("사용 불가능한 아이디입니다.");
				} else {
					// 아직 해당아이디로 회원가입한 사람이 없는 경우
					$('#id_check').attr('class', '');
					$('#id_check').toggleClass('w3-text-green');
					$('#id_check').html("사용 가능한 아이디입니다.");

				}
			},
			error : function () {
				alert('통신 에러');
			}
		});
		
	});
});
</script>


</head>
	

<body>
	<div class="container">
		<div class="joinLogo">J O I N</div>
		<div class="listbox">
	<form method="POST" action="/member/join.cls">

		<ul class="ulcl">
			<li id="idli"><label for="id">I D</label>
			<input type="text" id="id" name="id" required class="w3-rest">
			<input type="button" id="btn" value="idCheck" class="w3-col m2 w3-button w3-red">
			<p class="" id="id_check" class="w3-text-red"></p></li>
				
			<li><label for="pw">Password</label><input type="password" id="pw" name="pw" required>
			<p class="pcl" id="pw_check"></p></li>
			
			<li><label for="pw_e">Password Confirm</label><input type="password" id="pw_c" name="pw_c" required>
			<p class="pcl" id="pwc_check"></p></li>
			
			<li><label for="name">Name</label><input type="text" id="name" name="name" required>
			<p class="pcl" id="name_check"></p></li>
			
			<li><label for="email">E-mail</label><input type="text" id="mail" name="mail" required>
			<p class="pcl" id="email_check"></p></li>
			
			<li><label for="num">Phone Number</label><input type="text" id="tel" name="tel" placeholder="예] 010-1111-2222" required="required">
			<p class="pcl" id="num_check"></p>
			</li>


		</ul>
		<div class="inputcl">
			<input class="subcl" type="submit" id="join" name="join" value="Sign Up">
			<button id="returnBtn" onclick="location.href='/main'">Back</button>
		</div>

	</form>
	</div>
</div>
</body>
</html>