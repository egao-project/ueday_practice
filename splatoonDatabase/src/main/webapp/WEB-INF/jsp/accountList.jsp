<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント一覧</title>
</head>
<body>
<h1>アカウント一覧</h1>
<form action="?" method="post">
    <table border="1">
        <tr>
            <th>選択</th>
            <th>ユーザID</th>
            <th>ニックネーム</th>
        </tr>
        <c:forEach var="account" items="${accountList}">
            <tr>
                <td><input type="checkbox" name="userIds" value="${account.userId}" /></td>
                <td><c:out value="${account.userId}" /></td>
                <td><c:out value="${account.name}" /></td>
            </tr>
        </c:forEach>
    </table>
    <br>
        <input type="submit" value="ユーザー情報更新" formaction="EdiaAccountsServlet">
        <input type="submit" value="ユーザー削除" formaction="DeleteAccountServlet">
</form>
<a href="LoginServlet">戻る</a>
<a href="LogoutServlet">ログアウト</a>
</body>
</html>
