<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 11.12.2019
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Feedback</title>
</head>
<body>
<table>
    <tr>
        <th>Lp.</th>
        <th>Content</th>
        <th>Dodano:</th>
        <th>Fund Manager</th>

    </tr>
    <c:forEach items="${feedback}" var="feedback" varStatus="stat">
        <tr>
            <td>${stat.count}.</td>
            <td>${feedback.content}</td>
            <td>${feedback.localDateTime}</td>
            <td>${feedback.fundManager}</td>


            <td>
                <c:url value="/authors/delete" var="deleteURL">
                    <c:param name="id" value="${author.id}"/>
                </c:url>
                <c:url value="/authors/update" var="updateURL">
                    <c:param name="id" value="${author.id}"/>
                </c:url>
                <a href="${deleteURL}">Usuń</a>
                <a href="${updateURL}">Edytuj</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>