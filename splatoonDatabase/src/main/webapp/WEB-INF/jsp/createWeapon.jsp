<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ブキ登録画面</title>
</head>
<body>
<h1>ブキ新規登録</h1>
    <form action="CreateWeaponServlet" method="post">
        <input type="hidden" name="flag" value="create">
        名前:<input type="text" name="name" required><br>
        種類:<input type="text" name="type" required><br>
        射程:<input type="text" name="range" required><br>
        ダメージ:<input type="text" name="damage" required><br>
        サブ:<input type="text" name="sub" required><br>
        スペシャル:<input type="text" name="special" required><br>
        <input type="submit" value="登録">
    </form>
    <a href="WeaponListServlet">ブキ一覧画面へ</a>
</body>
</html>