<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<h2>主页</h2>

<form action="${pageContext.request.contextPath}/user/login" method="post">
    账号：<input type="text" name="userID"/><br/>
    密码：<input type="text" name="password"/><br/>
    <input type="submit" value="登录"/>
    <input type="reset" value="重置"/>
</form>
</body>
</html>
