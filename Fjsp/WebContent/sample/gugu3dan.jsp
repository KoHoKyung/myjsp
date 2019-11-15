<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	.gugu {
	border: 1px solid black;
display: inline-block;
	padding: 20px;
	
	}



</style>
<meta charset="UTF-8">
<title>구구단 3단</title>
</head>
<body>
	 <% for(int i = 2; i<10; i++){ %>
	<div class="gugu"><% for(int j = 1 ; j<10; j++){ %>
	<% if(i < 5) {%>
		<pre>       <%= i %>  X  <%= j %>    =    <%= i*j %>     </pre>
		<%}else if(i<8){ %>
		<p><%= i %> X <%= j %> = <%= i*j %><br></p>

		<%}else if(i<10){ %>

		<p><%= i %> X <%= j %> = <%= i*j %><br></p>
		<%} %>

		<%} %>
		</div>
  
		 
		<%} %>

	

</body>
</html>