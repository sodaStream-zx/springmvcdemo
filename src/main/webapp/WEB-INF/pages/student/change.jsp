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
<div style="margin-left: 25%;padding-top: 150px">
    <form action="/student/updateone" method="post">
        <input type="hidden" name="sid" value="${id}">
        <table>
            <tr>
                <th>姓名</th>
                <th>年龄</th>
            </tr>
            <tr>
                <td><input type="text" name="sname" value="${student.sname}"></td>
                <td><input type="number" name="sage" value="${student.sage}"></td>
            </tr>
            <tr>
                <td><input type="submit" name="comfirm"></td>
                <td><input type="reset" name="reset"></td>
            </tr>
        </table>
    </form>
    <h3><<a href="/index">返回主页</a>></h3>
</div>
</body>
</html>