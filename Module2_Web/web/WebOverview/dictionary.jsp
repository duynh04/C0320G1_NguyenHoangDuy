<%--
  Created by IntelliJ IDEA.
  User: NHD
  Date: 6/8/2020
  Time: 8:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<head>
    <title>Simple dictionary</title>
</head>
<body>
<h2>Vietnamese Dictionary</h2>
<form action="${pageContext.request.contextPath}/translate" method="post">
    <input type="text" name="txtSearch" placeholder="Enter your word: "/>
    <input type = "submit" id = "submit" value = "Search"/>
</form>
</body>
</html>