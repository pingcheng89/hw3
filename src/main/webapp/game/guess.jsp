<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guess Game</title>
<link href="<%= request.getContextPath()%>/style/mystyle.css" rel="stylesheet"></link>
</head>
<body>
	<h1>Guess Game</h1>
	<%-- Error Report --%>
	<% LinkedList<String> errors = (LinkedList<String>)request.getAttribute("errors"); %>
	<% if(errors != null){ %>
		<ul style="color:red; font-size: 0.8em">
		<table border ="0" style="margin: auto; text-align:left">
			<% for(String error : errors){ %>
			<tr><td><li><%= error %></li></td></tr>
	<%}%>
		</table>
		</ul>
	<%}%>
	<%-- End Error Report --%>
	
	<form action="GameController.do" method="post">
		<table border="0" style="margin:auto; text-align:left;">
			<tbody>
				<tr>
					<td>請猜1到${game.range}的數字：</td><td></td>
				</tr>
				<tr><td></td></tr><tr><td></td></tr>
				<tr>
					<td><input type="text" name="number"/></td><td><input type="submit" value="Guess!"></td>
				</tr>
				<tr><td></td></tr><tr><td></td></tr>
				
			</tbody>
		</table>
	</form>
	
	<p>您剩餘的次數： ${game.remains}</p>

</body>
</html>