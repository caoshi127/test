<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>《${detail.name}》</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
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

<div class="col-xs-6 col-md-offset-3">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">《 ${detail.name}》</h3>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <tbody id="bookInfo">
                <tr>
                    <th width="15%">书名</th>
                    <td>${detail.name}</td>
                </tr>
                <tr>
                    <th>作者</th>
                    <td>${detail.author}</td>
                </tr>
                <tr>
                    <th>出版社</th>
                    <td>${detail.publish}</td>
                </tr>
                <tr>
                    <th>ISBN</th>
                    <td>${detail.ISBN}</td>
                </tr>
                <tr>
                    <th>简介</th>
                    <td>${detail.introduction}</td>
                </tr>
                <tr>
                    <th>语言</th>
                    <td>${detail.language}</td>
                </tr>
                <tr>
                    <th>价格</th>
                    <td>${detail.price}</td>
                </tr>
                <tr>
                    <th>出版日期</th>
                    <td>
                        <fmt:formatDate value="${detail.pub_date}" pattern="yyyy-MM-dd"/>
                    </td>
                </tr>
                <tr>
                    <th>分类号</th>
                    <td>${detail.class_id}</td>
                </tr>
                <tr>
                    <th>数量</th>
                    <td>${detail.number}</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>

</div>

</body>
</html>
