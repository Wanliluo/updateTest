
<%--
  修改用户信息表单
  Created by IntelliJ IDEA.
  User: WanliLuo
  Date: 2016/3/31
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
  <title>修改用户信息表单</title>
</head>
<body>
  <form method="post" action="${website}/user/update/${id}" >
    原用户名 <input type="text" name="userName"><br>
    原密码   <input type="password" name="password"><br>
    新用户名 <input type="text" name="newUserName"><br>
    新年龄   <input type="text" name="newAge" pattern="[0-9]{1,3}"><br>
    新密码   <input type="password" name="newPassword"><br>
    再次输入新密码<input type="password" name="newPassword2"><br>
             <input type="submit" value="修改">
    ${message};
  </form>
</body>
</html>
