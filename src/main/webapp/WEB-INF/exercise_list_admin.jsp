<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: teos
  Date: 19.06.19
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of exercises</title>
</head>
<body>
<table width="50%">
    <tr>
        <th>Exercise ID:</th>
        <th>Exercise title:</th>
        <th>Exercise description:</th>
        <th></th>
    </tr>
    <c:forEach items="${exercise_list}" var="element">
        <tr>
            <td>${element.id}</td>
            <td>${element.title}</td>
            <td>${element.description}</td>
            <td><a href="${pageContext.servletContext.contextPath}/edit-exercise?id=${element.id}">Edit exercise</a></td>
        </tr>
    </c:forEach>
</table>
<a href="${pageContext.servletContext.contextPath}/add-exercise">Add new exercise</a>
</body>
</html>
