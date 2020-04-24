<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/5
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>${login_success}</h3>
<h3>${update_success}</h3>
<h3>${administrator_null_error}</h3>

<table>
    <th>管理员ID</th>
    <th>姓名</th>
    <tr>
        <td>
            ${administrator.adminID}
        </td>
        <td>
            ${administrator.name}
        </td>
    </tr>
</table><br>
<a href="${pageContext.request.contextPath}/administrator/insert/student">学生导入</a><br>
<a href="${pageContext.request.contextPath}/administrator/notice/publish">信息发布</a><br>
<a href="${pageContext.request.contextPath}/administrator/project/add">添加课题</a><br>
<a href="${pageContext.request.contextPath}/administrator/project/check">查看待审核课题</a><br>
<form action="${pageContext.request.contextPath}/administrator/project/adjustment" method="post">
    <input type="text" value="2016" name="yearClass">
    <input type="submit" value="调整学生课题">
</form><br>
<form action="${pageContext.request.contextPath}/user/logout" method="post">
    <input type="submit" value="用户注销">
</form>
</body>
</html>
