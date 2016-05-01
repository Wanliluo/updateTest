<%--
  Created by IntelliJ IDEA.
  User: WanliLuo
  Date: 2016/3/31
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>用户列表</title>
</head>
<body>
<table style="text-align: center;font-size: 30px">
  ${message}
  <form method = "post" action = "${website}/user/list">
    <tr>
      <th>序号</th>
      <th>姓名</th>
      <th>性别</th>
      <th>年龄</th>
      <th>操作</th>
    </tr>
    <c:forEach items = "${userList}" var = "user" varStatus = "status" >
      <tr>
        <td>${status.index+1}</td>
        <td>${user.userName}</td>
        <td>${user.sex}</td>
        <td>${user.age}</td>
        <td>
          <a href = "${website}user/delete?id=${user.id}">删除</a>
          <a href = "${website}user/change/${user.id}">修改</a>
        </td>
      </tr>
    </c:forEach>
  </form>
</table>
</body>
</html>