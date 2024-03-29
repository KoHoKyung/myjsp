<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%
	String[] clr = {"w3-red", "w3-orange", "w3-yellow", "w3-green", "w3-blue",
					"w3-indigo", "w3-purple", "w3-pink"		
};

request.setAttribute("CLR", clr);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/w3.css">
<script type="text/javascrit" src="/js/jquery-3.4.1.min.js">
</script>
<style>
</style>
<script type="text/javascript">
	
</script>

</head>
<body>
	<!-- 구구단 7단을 foreach 태그를 사용해서 출력하세요. -->
	<div class="w3-col m4">
		<p></p>
	</div>
	<div class="w3-container w3-col m4">
		<div class="w3-container w3-center">
			<c:forEach var="dan" begin="2" end="9" varStatus="vs">
				<div class="w3-col m4 pd1">
					<h3 class="w3-col w3-border ${CLR[vs.count -1]} w3-blue w3-padding w3-center">${dan}단</h3>
					<div class="w3-col w3-border w3-border${CLR[vs.count -1].substring(2)} w3-padding w3-card ">
						<%-- 			<c:forEach var="i" begin="1" end="9" step="1">
				<p>7 X ${i} = ${7*i }</p>
		</c:forEach> --%>
						<c:forEach var="gop" begin="1" end="9" varStatus="st">
							<p>${dan}*${gop} = ${dan* gop }</p>
						</c:forEach>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>


</body>
</html>