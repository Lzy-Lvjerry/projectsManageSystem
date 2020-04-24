<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/23
  Time: 21:06
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
<h3>${add_success}</h3>
<h2>毕设列表</h2>

<c:forEach items="${projects}" var="project">
    <a href="${pageContext.request.contextPath}/project/detail/${project.projectID}">${project.title}</a>
    <a href="${pageContext.request.contextPath}/project/update/${project.projectID}">修改</a>
    <a href="${pageContext.request.contextPath}/project/delete/${project.projectID}" onClick="return confirm('确定删除?');">删除</a>
    <br><br>
</c:forEach>
</body>
</html>
