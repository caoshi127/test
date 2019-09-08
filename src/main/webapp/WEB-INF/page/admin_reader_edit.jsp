<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>编辑读者信息</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css"/>
    <script type="text/javascript"  src="/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#admin_header").load("/admin_header.html");
        })
    </script>
</head>
<body background="/img/book2.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">
<div id="admin_header" style="padding-bottom: 80px"></div>
<div>
    <div class="col-xs-6 col-md-offset-3" style="position: relative;">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">编辑读者信息读者ID:&nbsp;&nbsp;[${oldReaderInfo.reader_id}]</h3>
            </div>
            <div class="panel-body">
                <form action="/reader_edit_do" method="post" id="readeredit" >
                    <input type="hidden" name="reader_id" value="${oldReaderInfo.reader_id}">
                    <div class="input-group">
                        <span class="input-group-addon">姓名</span>
                        <input type="text" class="form-control" name="name" id="name" value="${oldReaderInfo.name}" >
                    </div>
                    <div class="input-group">
                        <span  class="input-group-addon">性别</span>
                        <input type="text" class="form-control" name="gender" id="gender"  value="${oldReaderInfo.gender}" >
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon">出生日期</span>
                        <input type="text" class="form-control" name="birthday" id="birthday"  value="<fmt:formatDate value="${oldReaderInfo.birthday}" pattern="yyyy-MM-dd"/>" >
                    </div>
                    <div class="input-group">
                        <span  class="input-group-addon">地址</span>
                        <input type="text" class="form-control" name="address" id="address"  value="${oldReaderInfo.address}" >
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon">电话</span>
                        <input type="text" class="form-control" name="phone" id="phone" value="${oldReaderInfo.phone}" >
                    </div>
                    <input type="submit" value="确定" class="btn btn-success btn-sm" class="text-left">
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
