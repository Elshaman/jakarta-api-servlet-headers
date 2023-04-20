<%--
  Created by IntelliJ IDEA.
  User: Cristian Buitrago
  Date: 7/04/2023
  Time: 5:24 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulario de login </title>
</head>
<body>
<h1>iniciar sesion</h1>
<form action="/webapp-cookie/login" method="post">
    <div>
        <p>username: <input type="text" name="username"></p>
        <p>pass: <input type="password" name="password"></p>
        <input type="submit" value="Enviar" />
    </div>
</form>
</body>
</html>
