<%--
  Created by IntelliJ IDEA.
  User: NHD
  Date: 6/8/2020
  Time: 9:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action ="${pageContext.request.contextPath}/display-discount" method="post">
    <label>Product Description </label>
    <input type="text" name="product">
    <label>List Price </label>
    <input type="number" name="Price">
    <label>Discount Percent </label>
    <input type="number" name="Discount">
    <input type="submit" name="Calculate" value="Calculate Discount" >
</form>
</body>
</html>
