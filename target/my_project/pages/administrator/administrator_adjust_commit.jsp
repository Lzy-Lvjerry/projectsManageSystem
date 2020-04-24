<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/7
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form>
    <input type="text" name="studentID" value="${spMap.studentID}" readonly="readonly" />
    <input type="text" name="studentName" value="${spMap.studentName}" readonly="readonly" />
    <input type="text" name="projectID" value="${spMap.projectID}" readonly="readonly" />
    <input type="text" name="projectName" value="${spMap.projectName}" readonly="readonly" />
</form>
<br>
<form  action="${pageContext.request.contextPath}/administrator/project/adjust/${spMap.studentID}/commit" method="post">
    新的课题ID为：
    <input type="text" name="newProjectID" value="${spMap.projectID}" />
    <input type="submit" value="提交" />
</form>
</body>
</html>
