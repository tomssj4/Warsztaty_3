<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: teos
  Date: 31.05.19
  Time: 09:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of users in this group</title>
</head>
<body>
<table width="50%">
    <tr>
        <th>User name:</th>
        <th></th>
    </tr>
    <c:forEach items="${user_list_by_group_id}" var="element">
        <tr>
            <td>${element.userName}</td>
            <td><a href="${pageContext.servletContext.contextPath}/user-details?userId=${element.id}">Show user details</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
