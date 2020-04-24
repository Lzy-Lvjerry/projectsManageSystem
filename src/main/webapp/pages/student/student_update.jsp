<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/4
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>学生信息修改</h3>
<form action="${pageContext.request.contextPath}/student/update_success" method="post">
    学号: <input type="text" name="stuID" value="${student.stuID}" readonly="readonly" /><br/>
    姓名：<input type="text" name="name" value="${student.name}"/><br/>
    年龄: <input type="text" name="age" value="${student.age}"/><br/>
    性别: <input type="text" name="gender" value="${student.gender}"/><br/>
    专业：<input type="text" name="subject" value="${student.subject}"/><br/>
    学院：<input type="text" name="department" value="${student.department}"/><br/>
    <input type="hidden" value="0" name="permission" /><br/>
    地址：<input type="text" name="address" value="${student.address}"/><br/>
    电话：<input type="text" name="phone" value="${student.phone}"/><br/>
    <input type="text" name="projectID" hidden="hidden" value="${student.projectID}"/><br/>
    <input type="submit" value="修改"/>
</form>
</body>
</html>
