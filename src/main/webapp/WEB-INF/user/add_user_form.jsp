<%--
  Created by IntelliJ IDEA.
  User: teos
  Date: 20.06.19
  Time: 00:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user</title>
</head>
<body>
<form action="add-user" method="post">
    <p>Podaj ID grupy do ktorej nalezy uzytkownik</p> <input type="number" name="group_id"><br>
    <p>Podaj username</p> <input type="text" name="username"><br>
    <p>Podaj email</p> <input type="text" name="email"><br>
    <p>Podaj haslo</p> <input type="text" name="password"><br>
    <input type="submit" value="send">
</form>
</body>
</html>
