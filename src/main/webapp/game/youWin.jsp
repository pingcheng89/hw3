<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>你贏了</title>
<link href="<%= request.getContextPath() %>/style/mystyle.css" rel="stylesheet">
</head>
<body>
	<h1>Guess Game</h1>
	<h2>哇你太棒了吧，答對了！</h2>
	<h2>數字是 <%=request.getAttribute("luckynum") %></h2>
	<img src="https://i.imgur.com/IwpxmDf.gif" />
	<p><a href="../">回首頁</a><p>
</body>
</html>