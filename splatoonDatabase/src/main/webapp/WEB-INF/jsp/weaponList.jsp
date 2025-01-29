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
<form action="WeaponListServlet" method="get">
	<fieldset>
		<legend>絞り込み検索</legend>
		<label for="searchBy">検索項目</label>
		<label><input type="checkbox" name="searchBy" value="type"
		      <c:forEach var="item" items="${searchBy}">
                    <c:if test="${item == 'type'}">checked</c:if>
              </c:forEach>>ブキ種別</label>
        <label><input type="checkbox" name="searchBy" value="name"
              <c:forEach var="item" items="${searchBy}">
                    <c:if test="${item == 'name'}">checked</c:if>
              </c:forEach>>ブキ名</label>
        <label><input type="checkbox" name="searchBy" value="range"
              <c:forEach var="item" items="${searchBy}">
                    <c:if test="${item == 'range'}">checked</c:if>
              </c:forEach>>射程</label>
        <label><input type="checkbox" name="searchBy" value="damage"
              <c:forEach var="item" items="${searchBy}">
                    <c:if test="${item == 'damage'}">checked</c:if>
              </c:forEach>>威力</label>
        <label><input type="checkbox" name="searchBy" value="sub"
              <c:forEach var="item" items="${searchBy}">
                    <c:if test="${item == 'sub'}">checked</c:if>
              </c:forEach>>サブ</label>
        <label><input type="checkbox" name="searchBy" value="special"
              <c:forEach var="item" items="${searchBy}">
                    <c:if test="${item == 'special'}">checked</c:if>
              </c:forEach>>スペシャル</label>
        <br>
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