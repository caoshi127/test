<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${readerCard.userName}的主页</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css"/>
    <script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#reader_header").load("/reader_header.html");
        })
    </script>
</head>
<body background="/img/lizhi.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">
<div id="reader_header"style="padding-bottom: 100px"></div>

<c:if test="${!empty success}">
    <div class="alert alert-success alert-dismissable">
        <button type="button" class="close" data-dismiss="alert"
                aria-hidden="true">
            &times;
        </button>
            ${success}
    </div>
</c:if>
<c:if test="${!empty error}">
    <div class="alert alert-danger alert-dismissable">
        <button type="button" class="close" data-dismiss="alert"
                aria-hidden="true">
            &times;
        </button>
            ${error}
    </div>
</c:if>

<div class="col-xs-6 col-md-offset-3" style="position: relative;">
    <div class="panel panel-primary ">
        <div class="panel-heading">
            <h3 class="panel-title">修改密码</h3>
        </div>
        <div class="panel-body">
            <form method="post" action="reader_updatepwd_do" class="form-inline" id="repasswd">
                <div class="input-group">
                    <input type="password" id="oldPassword" name="oldPassword" placeholder="输入旧密码" class="form-control"
                           class="form-control">
                    <input type="password" id="newPassword" name="newPassword" placeholder="输入新密码" class="form-control"
                           class="form-control">
                    <input type="password" id="reNewPassword" name="reNewPassword" placeholder="再次输入新密码"
                           class="form-control" class="form-control">
                    <em id="hint" style="color: red"></em>
                    <br/>
                    <span>
                            <input type="submit" value="提交" class="btn btn-default">
                    </span>
                </div>
            </form>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(document).keyup(function () {
        var newPwd = $("#newPassword").val();
        var reNewPwd = $("#reNewPassword").val();
        var oldPwd = $("#oldPassword").val();

        if (newPwd != reNewPwd && newPwd != "" && reNewPwd != "" && newPwd.length == reNewPwd.length) {
            $("#hint").text("提示:两次输入的新密码不同，请检查!");
        } else {
            $("#hint").text("");
        }
    })

    $("#repasswd").submit(function () {
        var newPwd = $("#newPassword").val();
        var reNewPwd = $("#reNewPassword").val();
        var oldPwd = $("#oldPassword").val();

        if (newPwd == '' || reNewPwd == '' || oldPwd == '') {
            $("#hint").text("提示:请填写完整!");
            return false;
        } else if (newPwd != reNewPwd) {
            $("#hint").text("提示:两次输入的新密码不同，请检查!");
            return false;
        }
    })
</script>
</body>
</html>
