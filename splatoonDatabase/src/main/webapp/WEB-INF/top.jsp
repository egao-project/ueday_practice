<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トップ画面</title>
</head>
<body>
メニュー<br>
    <form method="get" action="MainController">
        <input type="hidden" name="action" value="login">
        <button type="submit">ログイン</button>
    </form>
    <br>
<!--    <form method="get" action="MainServlet">-->
<!--	    <input type="hidden" name="action" value="registerUser">-->
<!--	    <button type="submit">ユーザ登録</button>-->
<!--    </form>-->
</body>
</html>