<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ブキ一覧</title>
</head>
<body>
<h1>ブキ一覧</h1>
<c:forEach var="weapon" items="${weaponList}">
    <table border="1">
		<tr>
		<th><c:out value="${weapon.name}"/></th>
		</tr>
		<tr>
		<td>射程:<c:out value="${weapon.weaponRange}"/></td>
		</tr>
		<tr>
		<td>威力:<c:out value="${weapon.damage}"/></td>
		</tr>
		<tr>
		<td>サブ:<c:out value="${weapon.sub}"/></td>
		</tr>
		<td>スペシャル:<c:out value="${weapon.special}"/></td>
		<br>
    </table>
</c:forEach>
</body>
</html>