<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: WanliLuo
  Date: 2016/3/31
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
  <title>查询</title>
</head>
<body>
<form action="${website}user/query" method="post">
  请选择-查询条件<br>
    姓名:<input type="text" name="userName"><br>
    性别:<select name="sex">
         <option value="">请选择</option>
         <option value="男">男</option>
         <option value="女">女</option>
         </select><br>
    最大年龄年龄:<input type="text" name="maxAge"><br>
    最小年龄年龄:<input type="text" name="minAge"><br>
         <input type="submit" value="查询"><br>
    <c:if test="${!empty select}">
<table>
    <tr>
    <th>序号</th>
    <th>id</th>
    <th>姓名</th>
    <th>性别</th>
    <th>年龄</th>
    </tr>
    <c:forEach items = "${select}" var = "user" varStatus="status">
        <tr>
            <td>${status.index+1}</td>
            <td>${user.id}</td>
            <td>${user.userName}</td>
            <td>${user.sex}</td>
            <td>${user.age}</td>
        </tr>
    </c:forEach>
    </table>
    </c:if>
</form>
</body>
</html>
