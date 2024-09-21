<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lottery</title>
<link href="<%= request.getContextPath()%>/style/mystyle.css" rel="stylesheet"></link>
</head>
<body>
	<h1>Lottery</h1>
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
	
	<form action="lnController.do" method="post">
		<table border="0" style="margin:auto; text-align:left;">
			<tbody>
				<tr>
					<td>組數</td><td><input type="text" name="group"/></td>
				</tr>
				<tr><td></td></tr><tr><td></td></tr>
				<tr>
					<td>排除</td><td><input type="text" name="exclude"/></td>
				</tr>
				<tr><td></td></tr><tr><td></td></tr>
				<tr>
				<td></td><td><input type="submit" value="開始選號！"></td>
				</tr>
			</tbody>
		</table>
	</form>

</body>
</html>