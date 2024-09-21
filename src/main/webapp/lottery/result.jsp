<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lottery</title>
<link href="<%= request.getContextPath() %>/style/mystyle.css" rel="stylesheet"></link>
</head>
<body>
	<h1>Lottery</h1>
	<h2>選號結果出來了！</h2>
	
	<table border="0" style="margin:auto ; text-align:left">
		<tbody>
			<tr><td>輸入組數：</td><td>${lot.group}</td></tr>
			<tr><td>輸入排除數字：</td><td>${lot.exclude}</td></tr>
			<tr><td>樂透號碼：</td><td>${lot.result}</td></tr>
			
		</tbody>
	</table>
	<p><a href="../">回首頁</a><p>

</body>
</html>