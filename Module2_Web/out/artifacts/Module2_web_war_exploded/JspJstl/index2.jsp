<%--
  Created by IntelliJ IDEA.
  User: quan5
  Date: 6/7/2020
  Time: 8:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form action="/calculator" method="post">
    <fieldset>
        <legend>Calculator</legend>
        <label>First operand:</label>
        <input type="text" name="firstOperand"> <br><br>
        <label>Operator: </label>
        <select name="operator">
            <option value="+"> Addition </option>
            <option value="-"> Subtraction </option>
            <option value="*"> Multiplication </option>
            <option value="/"> Division </option>
        </select> <br><br>
        <label>Second operand: </label>
        <input type="text" name="secondOperand"> <br><br>
        <input type="submit" value="calculator">
    </fieldset>

</form>
</body>
</html>
