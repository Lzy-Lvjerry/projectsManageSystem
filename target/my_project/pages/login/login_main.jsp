<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/4
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="info">${password_error}</div>
<div class="info">${logout_success}</div>
<div class="info">${user_null_error}</div>
<div class="info">${has_logged_error}</div>
<form action="${pageContext.request.contextPath}/user/login" method="post">
    账号：<input type="text" name="userID"/><br/>
    密码：<input type="text" name="password"/><br/>
    <input type="submit" value="登录"/>
    <input type="reset" value="重置"/>
</form>
</body>
</html>
