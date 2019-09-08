<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录图书管理系统</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/js.cookie.js"></script>
    <style type="text/css">
        #login {
            height: 50%;
            width: 28%;
            margin-left: auto;
            margin-right: auto;
            margin-top: 5%;
            display: block;
            position: center;
        }

        .form-group {
            margin-bottom: 20px;
            margin-left: 40px;
            margin-right: 40px;
        }
    </style>

    <script type="text/javascript">
        $(function () {
            // 账号输入判断
            $("#userid").keyup(function () {
                if (isNaN($("#userid").val())) {
                    $("#info").text("提示:账号只能是数字");
                } else {
                    $("#info").text("");
                }
            });

            $("#login_button").click(function () {
                var $userid = $("#userid").val();
                var $passwd = $("#passwd").val();

                if ($userid == '') {
                    $("#info").text("账号不能为空");
                }
                else if ($passwd == '') {
                    $("#info").text("密码不能为空");
                }
                else {
                    $.post(
                        "${pageContext.request.contextPath}/login/check",
                        {userId : $userid, password : $passwd},
                        function (data) {
                            // data.stateCode 获取后台返回的json格式(Map集合也可)的数据
                            if (data.stateCode.trim() === "0") {
                                $("#info").text("提示: 账号或密码错误!");
                            }
                            else if (data.stateCode.trim() === "1") {
                                $("#info").text("提示: 管理员登录成功, 跳转中...");
                                setTimeout("window.location.href = '/admin_main.html'", 500);
                            }
                            else if (data.stateCode.trim() === "2") {
                                $("#info").text("提示: 读者登录成功, 跳转中...");
                                setTimeout("window.location.href = '/reader_main.html'", 500);
                            }
                        }
                    );
                }
            });
        });
    </script>
</head>

<body background="/img/timg.jpg"
      style="background-repeat: no-repeat; background-size: 100% 100%; background-attachment: fixed;">
<h2 style="text-align: center; color: white; font-family: '华文行楷'; font-size: 500%">图 书 馆</h2>

<div class="panel panel-default" id="login">
    <div class="panel-heading" style="background-color: #fff">
        <h3 class="panel-title">请登录</h3>
    </div>
    <div class="panel-body">
        <div class="form-group">
            <label for="userid">账号</label>
            <input type="text" class="form-control" id="userid" placeholder="请输入账号">
        </div>

        <div class="form-group">
            <label for="passwd">密码</label>
            <input type="password" class="form-control" id="passwd" placeholder="请输入密码">
        </div>

        <div class="form-group text-center">
            <p style="text-align: right;color: red;position: absolute" id="info"></p><br/>
            <button class="btn btn-primary btn-block" id="login_button">登录</button>
        </div>
    </div>
</div>
</body>
</html>
