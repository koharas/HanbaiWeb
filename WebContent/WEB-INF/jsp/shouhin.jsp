<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品</title>
</head>
<body>

<form action="shouhinadd" method="post">
商品名：<input type="text" name="sname"><br>
単価：<input type="text" name="tanka"><br>
<input type="submit" name="追加"><br>
</form>

<table>
<tr><th>商品ID</th><th>商品名</th><th>単価</th></tr>
<c:forEach items="${list}" var="shouhin">
	<tr>
	<td>${shouhin.sid}</td>
	<td>${shouhin.sname}</td>
	<td>${shouhin.tanka}</td>
	<td><a href="uriage?sid=${shouhin.sid}">売上</a></td>
</c:forEach>
</table>
</body>
</html>