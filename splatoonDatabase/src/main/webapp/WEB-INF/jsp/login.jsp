<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
<h1>ようこそ</h1>
<form action="LoginServlet" method="post">
    ユーザID:<input type="text" name="userId">
    <br>
    パスワード:<input type="password" name="pass">
    <br>
    <input type="submit" value="ログイン">
    <br>
</form>
<a href="TopServlet">トップへ</a>
</body>
</html>