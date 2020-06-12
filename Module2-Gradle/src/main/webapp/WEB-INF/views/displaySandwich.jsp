<%--
  Created by IntelliJ IDEA.
  User: NHD
  Date: 6/11/2020
  Time: 8:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:choose>
    <c:when test="${message == null}">
        <h1>Sandwich Spices</h1>
        <form:form action="/sandwich/save" modelAttribute="SelectedSpice" method="post">
            <form:checkboxes path="spice" items="${spices}"/><br>
            <form:button name="Submit">Save</form:button>
        </form:form>
    </c:when>
    <c:when test="${message != null}">
        <h3>You have selected: ${message} </h3>
    </c:when>
</c:choose>
</body>
</html>
