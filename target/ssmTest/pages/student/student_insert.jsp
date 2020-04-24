<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/4
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>学生导入</h3>
<form action="${pageContext.request.contextPath}/student/insert_student" method="post">
    *学号：<input type="text" name="stuID" /><br/>
    *密码：<input type="text" name="password"/><br/>
    *姓名：<input type="text" name="name" /><br/>
    *年龄：<input type="text" name="age" /><br/>
    *性别：<input type="text" name="gender" /><br/>
    专业：<input type="text" name="subject" /><br/>
    学院：<input type="text" name="department" /><br/>
    地址：<input type="text" name="address" /><br/>
    电话：<input type="text" name="phone" /><br/>
    <input type="submit" value="导入"/>
</form>
</body>
</html>
