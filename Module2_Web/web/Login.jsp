<%--
  Created by IntelliJ IDEA.
  User: NHD
  Date: 6/5/2020
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        .login {
            height:180px; width:230px;
            margin:0;
            padding:10px;
            border:1px #CCC solid;
        }
        .login input {
            padding:5px; margin:5px
        }
    </style>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/login">
    <div class="login">
        <h2>Login</h2>
        <label>
            <input type="text" name="username" size="30"  placeholder="username" />
        </label>
        <label>
            <input type="password" name="password" size="30" placeholder="password" />
        </label>
        <input type="submit" value="Sign in"/>
    </div>
</form>
</body>
</html>
