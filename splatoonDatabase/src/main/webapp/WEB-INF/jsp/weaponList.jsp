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
<c:if test="${dataMap.message != null}">
    <c:out value="${dataMap.message}"/>
</c:if>
<br>
<form action="MainController" method="get">
    <input type="hidden" name="action" value="getWeaponList" />
	<fieldset>
		<legend>絞り込み検索</legend>
		<label for="searchBy">検索項目</label>
		<label><input type="checkbox" name="searchBy" value="type"
		      <c:forEach var="item" items="${dataMap.searchBy}">
                    <c:if test="${item == 'type'}">checked</c:if>
              </c:forEach>>ブキ種別</label>
        <label><input type="checkbox" name="searchBy" value="name"
              <c:forEach var="item" items="${dataMap.searchBy}">
                    <c:if test="${item == 'name'}">checked</c:if>
              </c:forEach>>ブキ名</label>
        <label><input type="checkbox" name="searchBy" value="range"
              <c:forEach var="item" items="${dataMap.searchBy}">
                    <c:if test="${item == 'range'}">checked</c:if>
              </c:forEach>>射程</label>
        <label><input type="checkbox" name="searchBy" value="damage"
              <c:forEach var="item" items="${dataMap.searchBy}">
                    <c:if test="${item == 'damage'}">checked</c:if>
              </c:forEach>>威力</label>
        <label><input type="checkbox" name="searchBy" value="sub"
              <c:forEach var="item" items="${dataMap.searchBy}">
                    <c:if test="${item == 'sub'}">checked</c:if>
              </c:forEach>>サブ</label>
        <label><input type="checkbox" name="searchBy" value="special"
              <c:forEach var="item" items="${dataMap.searchBy}">
                    <c:if test="${item == 'special'}">checked</c:if>
              </c:forEach>>スペシャル</label>
        <br>
		<label for="searchKeyword">キーワード</label>
	    <input type="text" id="searchKeyword" name="searchKeyword" value="<c:out value='${dataMap.searchKeyword}'/>" />
		<label>
		<input type="radio" name="matchType" value="partial" <c:if test="${dataMap.matchType == 'partial'}">checked</c:if>> 部分一致
		</label>
		<label>
		<input type="radio" name="matchType" value="exact" <c:if test="${dataMap.matchType == 'exact'}">checked</c:if>> 完全一致
		</label>
		<button type="submit">検索</button>
	</fieldset>
</form>

<br>

<form action="MainController" method="get">
    <button type="submit" name="action" value="registerWeaponTransition">登録</button> 
	<button type="submit" name="action" value="editWeaponTransition">編集</button>
    <button type="submit" name="action" value="deleteWeaponTransition">削除</button>
    <button type="submit" name="action" value="home">戻る</button>
    <button type="submit" name="action" value="logout">ログアウト</button>
	<br>
	<br>
	<c:choose>
		<c:when test="${empty dataMap.weaponList}">
	    <c:out value="${dataMap.mismatchMsg}"/>
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
			        <c:forEach var="weapon" items="${dataMap.weaponList}">
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