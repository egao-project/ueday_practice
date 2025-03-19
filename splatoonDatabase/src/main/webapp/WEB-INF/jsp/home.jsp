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
   <form method="post" action="MainController">
        <input type="hidden" name="action" value="getWeaponList">
        <button type="submit">ブキ一覧</button>
    </form>

    <form method="post" action="MainController">
        <input type="hidden" name="action" value="getAccountList">
        <button type="submit">アカウント一覧</button>
    </form>

    <form method="post" action="MainController">
        <input type="hidden" name="action" value="top">
        <button type="submit">トップ画面へ</button>
    </form>
</body>
</html>