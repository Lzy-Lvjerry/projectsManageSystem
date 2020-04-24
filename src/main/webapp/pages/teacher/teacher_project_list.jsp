<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/5
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>

</head>
<body>
<a href="${pageContext.request.contextPath}/teacher/main.html">返回主页</a><br>
<c:forEach items="${projects}" var="project">
    <a href="${pageContext.request.contextPath}/project/project/detail/${project.projectID}">${project.title}</a>
    <a href="${pageContext.request.contextPath}/teacher/project/update/${project.projectID}">修改</a>
    <a href="${pageContext.request.contextPath}/teacher/project/recommit/${project.projectID}">重新发布</a>
    <a href="${pageContext.request.contextPath}/teacher/project/delete/${project.projectID}" onClick="return confirm('确定撤销?');">撤销</a>
    <br><br>
</c:forEach>

</body>
</html>
