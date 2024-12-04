<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン成功</title>
</head>
<body>
	ようこそ<c:out value="${userId}" />さん
	<br>
	
	<br>
	<a href="WeaponListServlet">ブキ一覧</a>
	<a href="AccountListServlet">アカウント一覧</a>
<a href="TopServlet">トップへ</a>
</body>
</html>