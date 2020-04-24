<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/4
  Time: 13:13
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
<h2>毕设列表</h2>
<c:forEach items="${projects}" var="project">
    <a href="${pageContext.request.contextPath}/project/detail/${project.projectID}">${project.title}</a>
    <a href="${pageContext.request.contextPath}/student/choose_project/${project.projectID}" onClick="return confirm('选择确认');">选择</a>
    <br><br>
</c:forEach>
</body>
</html>
