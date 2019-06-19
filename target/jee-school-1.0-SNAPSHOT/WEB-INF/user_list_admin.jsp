<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: teos
  Date: 19.06.19
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of users</title>
</head>
<body>
<table width="50%">
    <tr>
        <th>User ID:</th>
        <th>User group ID:</th>
        <th>User name:</th>
        <th>User email:</th>
        <th></th>
    </tr>
    <c:forEach items="${user_list}" var="element">
        <tr>
            <td>${element.id}</td>
            <td>${element.group_id}</td>
            <td>${element.userName}</td>
            <td>${element.email}</td>
            <td><a href="${pageContext.servletContext.contextPath}/edit-user?id=${element.id}">Edit user</a></td>
        </tr>
    </c:forEach>
</table>
<a href="${pageContext.servletContext.contextPath}/add-user">Add new user</a>
</body>
</html>
