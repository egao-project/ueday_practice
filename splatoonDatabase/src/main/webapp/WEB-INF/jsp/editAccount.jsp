<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント更新</title>
</head>
<body>
<h1>アカウント更新</h1>
<form action="UpdateAccountServlet" method="post">
    <input type="hidden" name="userId" value="${editAccount.userId}">
    新しいニックネーム: <input type="text" name="newName" required>
    <br><br>
    <input type="submit" value="更新">
</form>
<a href="AccountListServlet">戻る</a>
</body>
</html>
