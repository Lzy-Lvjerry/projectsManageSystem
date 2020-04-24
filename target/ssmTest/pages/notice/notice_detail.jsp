<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/20
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
通知标题：${notice.headline}
通知时间：${notice.date}
通知内容：${notice.detail}
<br>
<a href="${pageContext.request.contextPath}/notice/notice_main.html">返回通知列表</a>
</body>
</html>
