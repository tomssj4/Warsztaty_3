<%--
  Created by IntelliJ IDEA.
  User: teos
  Date: 20.06.19
  Time: 00:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit user</title>
</head>
<body>
<form action="edit-user" method="post">
    <input type="hidden" name="id" value="${id}">
    <p>Podaj nowe ID grupy do ktorej nalezy uzytkownik</p> <input type="number" name="group_id"><br>
    <p>Podaj nowy username</p> <input type="text" name="username"><br>
    <p>Podaj nowy email</p> <input type="text" name="email"><br>
    <input type="submit" value="send">
</form>
</body>
</html>