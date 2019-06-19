<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: teos
  Date: 31.05.19
  Time: 09:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User details</title>
</head>
<body>
Szczegoly uzytkownika:<br>
User id: ${user_details.id}<br>
User name: ${user_details.userName}<br>
Email: ${user_details.email}<br>
User group ID: ${user_details.group_id}<br>
<br>
<ul>Solution list:
    <c:forEach items="${list_of_user_solutions}" var="elements">
            <li>Solution ID: ${elements.id}, Created: ${elements.created}, Updated: ${elements.updated}, Exercise ID: ${elements.exerciseId}</li>
    </c:forEach>
        </ul>
</body>
</html>
