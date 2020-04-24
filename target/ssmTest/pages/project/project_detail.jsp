<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/23
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
毕设标题：${project.title}
毕设时间：${project.date}
毕设内容：${project.detail}
<br>
<a href="${pageContext.request.contextPath}/project/project_main.html">返回毕设列表</a>
<a href="javascript:;" onClick="javascript:history.back(-1);">返回</a>
</body>
</html>
