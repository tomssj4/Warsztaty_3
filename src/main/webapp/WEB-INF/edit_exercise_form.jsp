<%--
  Created by IntelliJ IDEA.
  User: teos
  Date: 20.06.19
  Time: 01:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit exercise</title>
</head>
<body>
<form action="edit-exercise" method="post">
    <input type="hidden" name="id" value="${id}">
    <p>Podaj nowy tytul</p> <input type="text" name="title"><br>
    <p>Podaj nowy opis</p> <input type="text" name="description"><br>
    <input type="submit" value="send">
</form>
</body>
</html>
