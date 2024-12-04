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
<c:if test="${message != null}">
    <c:out value="${message}"/>
</c:if>
<br>
<form action="?" method="post">
    <input type="submit" value="登録" formaction="CreateWeaponServlet"> 
	<input type="submit" value="編集" formaction="EditWeaponServlet">
    <input type="submit" value="削除" formaction="DeleteWeaponServlet">
	<a href="LoginServlet">戻る</a>
	<a href="LogoutServlet">ログアウト</a>
    <table border="1">
        <thead>
            <c:if test="${empty loopCounter}">
		        <tr>
		              <th></th>
		              <th>ブキ名</th>
		              <th>射程</th>
		              <th>威力</th>
		              <th>サブ</th>
		              <th>スペシャル</th>
		        </tr>
            </c:if>
        </thead>
        <c:set var="loopCounter" value="0"/>
        <c:forEach var="weapon" items="${weaponList}">
			<tr>
			    <th><input type="checkbox" name="weaponIds" value="${weapon.weaponId}" /></th>
				<td><c:out value="${weapon.name}"/></td>
				<td><c:out value="${weapon.range}"/></td>
				<td><c:out value="${weapon.damage}"/></td>
				<td><c:out value="${weapon.sub}"/></td>
				<td><c:out value="${weapon.special}"/></td>
			</tr>
        </c:forEach>
    </table>
</form>
</body>
</html>