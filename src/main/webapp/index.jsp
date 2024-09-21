<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的作業</title>
<link href="<%= request.getContextPath()%>/style/mystyle.css" rel="stylesheet"></link>
</head>
<body>
	<h1>我的作業</h1>
	<h2>請點選</h2>
	<p>▶ <a href="lottery/main.jsp" style="text-align:left;">Lottery</a></p>
	<p>▶ <a href="game/GameController.do" style="text-align:left;">Guess Game</a></p>
</body>
</html>