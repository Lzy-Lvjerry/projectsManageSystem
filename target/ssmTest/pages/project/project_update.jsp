<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/23
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/project/update/commit" method="post">
    <input type="text" hidden="hidden" value="${project.projectID}" name="projectID">
    <input type="text" value="${project.title}" name="title"/><br>
    <textarea name="detail">${project.detail}</textarea><br>
    <input type="submit" value="确认修改"/>
</form>
</body>
</html>
