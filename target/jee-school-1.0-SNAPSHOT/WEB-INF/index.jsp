<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: teos
  Date: 25.05.19
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp" %>
<table width="50%">
    <tr>
        <th>Users ID:</th>
        <th>Exercise ID:</th>
        <th>Created:</th>
        <th></th>
    </tr>
    <c:forEach items="${recent_solution_list}" var="element">
        <tr>
            <td>${element.usersId}</td>
            <td>${element.exerciseId}</td>
            <td>${element.created}</td>
            <td><a href="${pageContext.servletContext.contextPath}/solution-details?solutionId=${element.id}">Show solution details</a></td>
        </tr>
    </c:forEach>
</table>
<%@include file="footer.jsp" %>
</body>
</html>
