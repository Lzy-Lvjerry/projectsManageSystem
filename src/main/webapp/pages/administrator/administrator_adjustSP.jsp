<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/6
  Time: 19:49
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
<h3>课题调整列表</h3>
<a href="${pageContext.request.contextPath}/administrator/main.html">返回主页</a>
<c:forEach items="${spMapList}" var="spMap">
    <form action="${pageContext.request.contextPath}/administrator/project/adjust/${spMap.studentID}" method="post">
        <input type="text" name="studentID" value="${spMap.studentID}" readonly="readonly" />
        <input type="text" name="studentName" value="${spMap.studentName}" readonly="readonly" />
        <input type="text" name="projectID" value="${spMap.projectID}" readonly="readonly" />
        <input type="text" name="projectName" value="${spMap.projectName}" readonly="readonly" />
        <input type="submit" value="调整" />
    </form>
</c:forEach>
</body>
</html>
