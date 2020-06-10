<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>View product</title>
</head>
<body>
<h1>product details</h1>
<p>
    <a href="${pageContext.request.contextPath}/products">Back to product list</a>
</p>
<table>
    <tr>
        <td>Name: </td>
        <td>${requestScope["product"].name}</td>
    </tr>
    <tr>
        <td>Price: </td>
        <td>${requestScope["product"].price}</td>
    </tr>
</table>
</body>
</html>
