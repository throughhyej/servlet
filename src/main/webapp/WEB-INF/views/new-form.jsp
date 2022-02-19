<%--
  Created by IntelliJ IDEA.
  User: throughhjsview
  Date: 2022/02/19
  Time: 8:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- 절대경로(/)가 아닌, 상태경로로 설정: 현재 URL이 속한 계층 경로의 save가 호출, 절대경로로 하는 게 좋음 --%>
<form action="save" method="post">
    username:   <input type="text" name="username" />
    age:        <input type="text" name="age" />
    <button type="submit">전송</button>
</form>
</body>
</html>

