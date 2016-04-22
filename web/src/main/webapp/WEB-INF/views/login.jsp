<%--
  Created by IntelliJ IDEA.
  User: 秦
  Date: 2016/4/22
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>学生管理系统--登录页</title>
</head>
<body>
<h1>学生管理系统</h1>
<form action = "${website}/1/login" method="post">
    用户名<input type="text" name="userName"><br>
    密码<input type="password" name="password"><br>
    <input type="submit" value="登录">
    ${message}<br>
</form>
</body>
</html>
