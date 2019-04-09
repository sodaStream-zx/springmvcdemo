<%@ page language="java" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <title>Title</title>
</head>
<body>
<div style="text-align: center" class="table-responsive">
    <table class="table">
        <tr>
            <th>id</th>
            <th>name</th>
            <th>age</th>
            <th>change</th>
            <th>delete</th>
        </tr>
        <c:forEach var="student" items="${studentlist}">
            <tr>
                <td>${student.sid}</td>
                <td>${student.sname}</td>
                <td>${student.sage}</td>
                <td><a href="/student/changepage/${student.sid}">change</a></td>
                <td><a href="/student/delete?sid=${student.sid}">delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <h3><<a href="/student/addpage">点击添加</a>></h3>
    <h3><<a href="/index">返回主页</a>></h3>
    <h2>${msg}</h2>
</div>
</body>
</html>