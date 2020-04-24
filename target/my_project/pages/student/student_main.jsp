<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/4
  Time: 12:11
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
<h3>${student_null_error}</h3>

<table>
    <th>学号</th>
    <th>姓名</th>
    <th>年龄</th>
    <th>性别</th>
    <th>毕设ID</th>
    <tr>
        <td>
            ${student.stuID}
        </td>
        <td>
            ${student.name}
        </td>
        <td>${student.age}</td>
        <td>
            ${student.gender}
        </td>
        <td>
            ${student.projectID}
        </td>
    </tr>
</table><br>
<form action="${pageContext.request.contextPath}/student/projects" method="post">
    <input type="submit" value="选择课题"/>
</form><br>
<form action="${pageContext.request.contextPath}/student/update" method="post">
    <input type="submit" value="修改信息"/>
</form><br>
<form action="${pageContext.request.contextPath}/user/logout" method="post">
    <input type="submit" value="用户注销">
</form><br>
</body>
</html>
