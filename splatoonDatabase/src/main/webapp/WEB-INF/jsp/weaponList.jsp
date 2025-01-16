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
<form action="SearchWeaponListServlet" method="get">
	<fieldset>
		<legend>絞り込み検索</legend>
		<label for="searchBy">検索項目</label>
		<select id="searchBy" name="searchBy">
		    <option value="type" <c:if test="${searchBy == 'type'}">selected</c:if>>ブキ種別</option>
			<option value="name" <c:if test="${searchBy == 'name'}">selected</c:if>>ブキ名</option>
			<option value="sub" <c:if test="${searchBy == 'sub'}">selected</c:if>>サブ</option>
			<option value="special" <c:if test="${searchBy == 'special'}">selected</c:if>>スペシャル</option>
		</select>
		<label for="searchKeyword">キーワード</label>
	    <input type="text" id="searchKeyword" name="searchKeyword"value="<c:out value='${searchKeyword}'/>" />
		<label>
		<input type="radio" name="matchType" value="partial" <c:if test="${matchType == 'partial'}">checked</c:if>> 部分一致
		</label>
		<label>
		<input type="radio" name="matchType" value="exact" <c:if test="${matchType == 'exact'}">checked</c:if>> 完全一致
		</label>
		<button type="submit">検索</button>
	</fieldset>
</form>

<br>

<form action="?" method="post">
    <button type="submit" formaction="CreateWeaponServlet">登録</button> 
	<button type="submit" formaction="EditWeaponServlet">編集</button>
    <button type="submit" formaction="DeleteWeaponServlet">削除</button>
	<a href="LoginServlet">戻る</a>
	<a href="LogoutServlet">ログアウト</a>
	<br>
	<br>
	<c:choose>
		<c:when test="${empty weaponList}">
	    <c:out value="${mismatchMsg}"/>
		</c:when>
			<c:otherwise>
			    <table border="1">
			        <thead>
					        <tr>
					              <th></th>
					              <th>ブキ種別</th>
					              <th>ブキ名</th>
					              <th>射程</th>
					              <th>威力</th>
					              <th>サブ</th>
					              <th>スペシャル</th>
					        </tr>
			        </thead>
			        <c:forEach var="weapon" items="${weaponList}">
						<tr>
						    <th><input type="checkbox" name="weaponId" value="${weapon.weaponId}" /></th>
						    <td><c:out value="${weapon.type}"/></td>
							<td><c:out value="${weapon.name}"/></td>
							<td><c:out value="${weapon.range}"/></td>
							<td><c:out value="${weapon.damage}"/></td>
							<td><c:out value="${weapon.sub}"/></td>
							<td><c:out value="${weapon.special}"/></td>
						</tr>
			        </c:forEach>
			    </table>
		    </c:otherwise>
    </c:choose>
</form>
</body>
</html>