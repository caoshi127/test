<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript" src="/js/jquery-3.2.1.js"></script>

<script type="text/javascript">
    $(function () {
        $('#head-nav > li').each(function () {
            $(this).on('mouseover', function () {
                $(this).addClass("active")
            })

            $(this).on('mouseout', function () {
                $(this).removeClass("active")
            })
        })
    })
</script>

<nav class="navbar navbar-default" role="navigation" style="background-color:#fff">
    <div class="container-fluid">
        <div class="navbar-header" style="margin-left: 8%;margin-right: 1%">
            <a class="navbar-brand " href="reader_main.html"><p class="text-primary" style="font-family: 华文行楷; font-size: 200%; ">我的图书馆</p></a>
        </div>
        <div class="collapse navbar-collapse" id="example-navbar-collapse">
            <ul class="nav navbar-nav navbar-left" id="head-nav">
                <li>
                    <a href="reader_books.html">
                        图书查询
                    </a>
                </li>
                <li>
                    <a href="reader_info.html" >
                        个人信息
                    </a>
                </li>
                <li>
                    <a href="mylend.html" >
                        我的借还
                    </a>
                </li>
                <li>
                    <a href="reader_updatepwd.html" >
                        密码修改
                    </a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="reader_info.html">${readerCard.userName}, 已登录</a></li>
                <li><a href="login.html">退出</a></li>
            </ul>
        </div>
    </div>
</nav>

