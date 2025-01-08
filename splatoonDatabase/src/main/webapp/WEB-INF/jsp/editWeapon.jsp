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
<c:if test="${not empty errors}">
    <ul style="color: red;">
        <c:forEach var="error" items="${errors}">
            <li>${error}</li>
        </c:forEach>
    </ul>
</c:if>
	<form action="UpdateWeaponServlet" method="post">
		<input type="hidden" name="weaponId" value="${weaponId}">
		名前:<input type="text" name="name" value="${weapon.name}" required pattern="^.{1,20}$" title="20文字以内で入力してください。"><br>
		種類:<input type="text" name="type" value="${weapon.type}" required pattern="^[ァ-ヶー]{1,10}+$" title="全角カタカナ、10文字以内で入力してください。"><br>
		射程:<input type="text" name="range" value="${weapon.range}" required pattern="^[0-9.]{1,5}+$" title="半角数字と.(ドット)、5文字以内で入力してください。"><br>
		ダメージ:<input type="text" name="damage" value="${weapon.damage}" required pattern="^[0-9.]{1,10}+$" title="半角数字と.(ドット)、10文字以内で入力してください。"><br>
		サブ:<input type="text" name="sub" value="${weapon.sub}" required pattern="^[ァ-ヶー]{1,20}+$" title="全角カタカナ、20文字以内で入力してください。"><br>
		スペシャル:<input type="text" name="special" value="${weapon.special}" required pattern="^[ァ-ヶー]{1,20}+$" title="全角カタカナ、20文字以内で入力してください。"><br>
		<input type="submit" value="更新">
    </form>
</body>
</html>