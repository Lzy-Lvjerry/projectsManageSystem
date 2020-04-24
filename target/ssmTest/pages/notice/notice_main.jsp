<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/20
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>

<body>

<h3>${pub_success}</h3>
<h2>通告列表</h2>

<c:forEach items="${notices}" var="notice">
    <a href="${pageContext.request.contextPath}/notice/detail/${notice.noticeID}">${notice.headline}</a>
    <a href="${pageContext.request.contextPath}/notice/update/${notice.noticeID}">修改</a>
    <a href="${pageContext.request.contextPath}/notice/delete/${notice.noticeID}" onClick="return confirm('确定删除?');">删除</a>
    <br><br>
</c:forEach>


</body>
</html>
