
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
<form action="${website}/user/select" method="post">
  请选择-查询条件<br>
  性别:<select name="sex">
       <option value="">请选择</option>
       <option value="男">男</option>
       <option value="女">女</option>
       </select><br>
  姓名:<input type="text" name="userName">
  分数少于: <input type="text" name="score">
            <input type="submit" value="查询">

  <td>应聘人员姓名&nbsp;
    <input type="text" name="queryCol1" value="${queryCol1}" style="width:100"/>
    学历&nbsp;
    <%=DropdownListBoxUtil.getList("queryCol2","IDBSupportService3","HR_XUELI","${currUser}","zh-CN","","${queryCol2}") %>
    出生日期&nbsp;
    <input type="text" name="queryCol3"  class="wDate"    onfocus="new WdatePicker(this)"   value="${queryCol3}" style="width:100"/>
    ewwe&nbsp;
    <input type="text" name="queryCol4"/>
    <input type="text" name="nameField"/> 
    <image src="<%=request.getContextPath()%>/images/icon.gif" onclick="window.open('<%=request.getContextPath()%>/hr/popupHrResume.action?codeField=queryCol4&nameField=nameField');"/>     
    <a href="#" class="button" onClick="doSearch()">
     <s:text name="button.query"/></a>&nbsp;&nbsp;
  </td>

</form>
</body>
</html>
