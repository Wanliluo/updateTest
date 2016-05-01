
<%--
  Created by IntelliJ IDEA.
  User: WanliLuo
  Date: 2016/3/31
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
  <title>新增用户表单</title>
</head>
<body>
  <form method="post" action="${website}/user/new">
    用户名<input type="text" name="userName"><br>
    密码<input type="password" name="password"><br>
    确认密码<input type="password" name="password2"><br>
    性别:<select name="sex">
    <option value="">请选择</option>
    <option value="男">男</option>
    <option value="女">女</option>
  </select><br>
    年龄 <input type="text" name="age" pattern="[0-9]{1,3}"><br>
    <input type="submit" value="注册">
    ${message}<br>
  </form>
</body>
</html>
