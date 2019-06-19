<%--
  Created by IntelliJ IDEA.
  User: teos
  Date: 20.06.19
  Time: 01:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit group</title>
</head>
<body>
<form action="edit-group" method="post">
    <input type="hidden" name="id" value="${id}">
    <p>Podaj nowa nazwe grupy</p> <input type="text" name="name"><br>
    <input type="submit" value="send">
</form>
</body>
</html>
