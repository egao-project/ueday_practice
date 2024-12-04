<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ブキ編集画面</title>
</head>
<body>
<h1>ブキ編集</h1>
<c:out value="${weapon.name}"></c:out>
	<form action="UpdateWeaponServlet" method="post">
		<input type="hidden" name="weaponId" value="${weaponId} ">
		名前:<input type="text" name="name" value="${weapon.name}" required><br>
		種類:<input type="text" name="type" value="${weapon.type}" required><br>
		射程:<input type="text" name="range" value="${weapon.range}" required><br>
		ダメージ:<input type="text" name="damage" value="${weapon.damage}" required><br>
		サブ:<input type="text" name="sub" value="${weapon.sub}" required><br>
		スペシャル:<input type="text" name="special" value="${weapon.special}" required><br>
		<input type="submit" value="更新">
    </form>
</body>
</html>