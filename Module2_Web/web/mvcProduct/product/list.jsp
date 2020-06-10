<%--
  Created by IntelliJ IDEA.
  User: NHD
  Date: 6/8/2020
  Time: 1:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Products</h1>
<p>
    <a href="${pageContext.request.contextPath}/products?action=create">Create new product</a>
</p>
<form method="post">
    <label>
        <input type="text" placeholder="Search.." name="search">
    </label>
    <button type="submit" >Search</button>
</form>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<table border="1">
    <tr>
        <td>Name</td>
        <td>Price</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${requestScope["products"]}' var="product">
        <tr>
            <td><a href="${pageContext.request.contextPath}/products?action=view&id=${product.id}">${product.name}</a></td>
<%--            <td>${product.name}</td>--%>
            <td>${product.price}</td>
            <td><a href="${pageContext.request.contextPath}/products?action=edit&id=${product.id}">edit</a></td>
            <td><a href="${pageContext.request.contextPath}/products?action=delete&id=${product.id}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
