<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>你輸了</title>
<link href="<%= request.getContextPath() %>/style/mystyle.css" rel="stylesheet">
</head>
<body>
	<h1>Guess Game</h1>
	<h2>很抱歉，你輸了，沒猜對...</h2>
	<img src="https://i.imgur.com/zYqWVlN.jpeg" width="30%" height="30%"/>
	<p><a href="../">回首頁</a><p>
</body>
</html>