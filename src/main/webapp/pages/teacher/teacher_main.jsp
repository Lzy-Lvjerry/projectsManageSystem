<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/5
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>${pub_success}</h3>

<h4>教师ID: ${teacher.teaID}</h4>
<h4>名字: ${teacher.name}</h4>
<form action="${pageContext.request.contextPath}/teacher/project/publish" method="post">
    <input type="submit" value="发布课题"/>
</form><br>
<form action="${pageContext.request.contextPath}/teacher/project/list" method="post">
    <input type="submit" value="我的课题列表"/>
</form><br>
<a href="${pageContext.request.contextPath}/teacher/project/check">查看系统待审核的课题</a><br>

<a href="${pageContext.request.contextPath}/teacher/project/nopass">查看我的未审核完的课题</a><br>
<a href="${pageContext.request.contextPath}/teacher/project/passfail">查看我的审核失败的课题</a><br>
<form action="${pageContext.request.contextPath}/user/logout" method="post">
    <input type="submit" value="用户注销">
</form>
</body>
</html>
