<%--
  Created by IntelliJ IDEA.
  User: ss
  Date: 2021/7/6
  Time: 12:34 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
这是登陆页面。login.jsp<br>
<form action="http://localhost:8080/myWeb_war_exploded/LoginServlet" method="get">
    用户名 <input type="text" name="username"/><br>
    密码 <input type="password" name="password"/> <br>
    <input type="submit"/>
</form>
</body>
</html>
