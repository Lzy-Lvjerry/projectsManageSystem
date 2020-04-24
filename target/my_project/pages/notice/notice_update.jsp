<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/21
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/notice/update/commit" method="post">
    <input type="text" hidden="hidden" value="${notice.noticeID}" name="noticeID">
    <input type="text" value="${notice.headline}" name="headline"/><br>
    <textarea name="detail">${notice.detail}</textarea><br>
    <input type="submit" value="确认修改"/>
</form>
</body>
</html>
