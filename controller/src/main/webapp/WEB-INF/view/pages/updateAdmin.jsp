<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: s-afe
  Date: 18.05.2022
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Update admin</title>
</head>
<body>
<h1>Update admin</h1>

<fieldset>
    <form action="updateAdmin" method="post">
        Admin name <input name="Name"  value="${admin.name}" type="Name"><br>

        <input type='submit' value='Create'>
    </form>
</fieldset>
</body>
</html>