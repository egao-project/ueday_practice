<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログアウト画面</title>
</head>
<body>
	ログアウトしました<br>
<form method="post" action="MainController">
	<input type="hidden" name="action" value="top">
    <button type="submit">トップへ</button>
</form>
</body>
</html>