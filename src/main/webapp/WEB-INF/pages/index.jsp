<%@ page language="java" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div style="margin: 0 auto;text-align: center">
    <h1>welcom ${sessionScope.loginUser} Index page</h1>
    <p>
    <h2>cookies:</h2><br>
    <h3>name:${name}</h3>
    <h3>pwd:${pwd}</h3>
    </p>
    <h2><a href="/student/findall">>主页<</a></h2>
</div>
</body>
</html>