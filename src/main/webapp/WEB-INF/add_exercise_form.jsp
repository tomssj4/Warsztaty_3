<%--
  Created by IntelliJ IDEA.
  User: teos
  Date: 20.06.19
  Time: 00:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add exercise</title>
</head>
<body>
<form action="add-exercise" method="post">
    <p>Podaj tytul</p> <input type="text" name="title"><br>
    <p>Podaj opis</p> <input type="text" name="description"><br>
    <input type="submit" value="send">
</form>
</body>
</html>
