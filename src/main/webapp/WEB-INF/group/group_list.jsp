<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: teos
  Date: 31.05.19
  Time: 09:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Group List</title>
</head>
<body>
<table width="50%">
    <tr>
        <th>Group ID:</th>
        <th>Group name:</th>
        <th></th>
    </tr>
    <c:forEach items="${group_list}" var="element">
        <tr>
            <td>${element.id}</td>
            <td>${element.name}</td>
            <td><a href="${pageContext.servletContext.contextPath}/group-users?groupId=${element.id}">Show users in this group</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
