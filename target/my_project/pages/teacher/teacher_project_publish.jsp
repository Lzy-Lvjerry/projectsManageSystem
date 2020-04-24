<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/5
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/teacher/project/publish/commit" method="post">
    毕设标题：<input type="text" name="title"/><br/>
    毕设内容：<textarea name="detail"></textarea>
    <input type="submit" value="发布" onclick="return confirm('确认发布');"/>
</form>
</body>
</html>
