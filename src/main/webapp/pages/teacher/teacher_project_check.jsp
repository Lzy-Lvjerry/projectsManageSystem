<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/6
  Time: 18:15
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
<a href="${pageContext.request.contextPath}/teacher/main.html">返回主页</a>
<c:forEach items="${projects}" var="project">
    <a href="${pageContext.request.contextPath}/project/detail/${project.projectID}">${project.title}</a>
    <a href="${pageContext.request.contextPath}/teacher/project/check/pass/${project.projectID}" onclick="return confirm('确定同意');">同意通过</a>
    <a href="${pageContext.request.contextPath}/teacher/project/check/nopass/${project.projectID}" onClick="return confirm('确定拒绝');">拒绝通过</a>
    <br><br>
</c:forEach>
</body>
</html>
