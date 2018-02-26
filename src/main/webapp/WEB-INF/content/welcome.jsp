<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/2/25
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>welcome</title>
</head>
<body>
欢迎您：${member.username}
${sessionScope.get("member").username}
</body>
</html>
