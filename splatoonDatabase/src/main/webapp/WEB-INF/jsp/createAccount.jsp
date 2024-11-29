<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ登録画面</title>
</head>
<body>
<h1>ユーザ登録画面</h1>
<form action="CreateAccount" method="post">
    ユーザID:<input type="text" name="userId">
    <br>
    パスワード:<input type="password" name="pass">
    <br>
    ニックネーム:<input type="text" name="name">
    <input type="submit" value="登録">
    <br>
</form>
<a href="TopServlet">トップへ</a>
</body>
</html>