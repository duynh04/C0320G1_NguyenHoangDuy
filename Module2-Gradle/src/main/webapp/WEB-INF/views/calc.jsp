<%--
  Created by IntelliJ IDEA.
  User: NHD
  Date: 6/11/2020
  Time: 9:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Calculator</h2>
<form name="Calc" action="${pageContext.request.contextPath}/calculator" method="post">
    <label>
        <input type="number" name="num1" step="any" value="${num1}">
    </label>
    <label>
        <input type="number" name="num2" step="any" value="${num2}">
    </label><br>
    <p>------------------------------------------------------------------</p>
    <input type="submit" name="add" value="Add">
    <input type="submit" name="sub" value="Subtract">
    <input type="submit" name="mul" value="Multiply">
    <input type="submit" name="div" value="Divide">
</form>
<h3>Result: ${result}</h3>
</body>
</html>
