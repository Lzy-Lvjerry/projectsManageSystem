<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/16
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table class="new-pad">
    <th  class="sort-column needBy">ID</th>
    <th  class="sort-column needBy">Name</th>
    <th  class="sort-column content">Money</th>
<tr>
    <td>
        ${account.id}
    </td>
    <td>${account.name}</td>
    <td>
        ${account.money}
    </td>
</tr>
</table>
</body>
</html>
