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
<form action="/student/addone" method="post" class="form-horizontal" role="form">
    <div class="form-group">
        <label for="firstname" class="col-sm-2 control-label">姓名</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="firstname" name="sname"
                   placeholder="请输入名字">
        </div>
    </div>
    <div class="form-group">
        <label for="lastname" class="col-sm-2 control-label">密码</label>
        <div class="col-sm-6">
            <input type="number" class="form-control" id="lastname" name="sage"
                   placeholder="请输入名字">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-6">
            <div class="checkbox">
                <input type="submit" value="提交">
                <input type="reset" value="重置">
            </div>
        </div>
    </div>
    <button class="button"><<a href="/index">返回主页</a>></button>
</form>

</div>
</body>
</html>