<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ブキ登録結果</title>
</head>
<body>
	<p><c:out value="${dataMap.message}" /></p>
    <form action="MainController" method="get">
        <button type="submit" name="action" value="getWeaponList">ブキ一覧画面へ</button> 
    </form>
</body>
</html>