<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>编辑图书信息</title>
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

<div class="col-xs-6 col-md-offset-3" style="position: relative;">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">编辑《 ${oldBookInfo.name}》</h3>
        </div>

        <div class="panel-body">
            <form action="admin_book_edid_do" method="post" id="edit">
                <%--图书id--%>
                <input type="hidden" name="book_id" value="${oldBookInfo.book_id}">
                <div class="input-group">
                    <span  class="input-group-addon">书名</span>
                    <input type="text" class="form-control" name="name" id="name" value="${oldBookInfo.name}">
                </div>
                <div class="input-group">
                    <span class="input-group-addon">作者</span>
                    <input type="text" class="form-control" name="author" id="author" value="${oldBookInfo.author}" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">出版社</span>
                    <input type="text" class="form-control" name="publish" id="publish"  value="${oldBookInfo.publish}" >
                </div>
                <div class="input-group">
                    <span class="input-group-addon">ISBN</span>
                    <input type="text" class="form-control" name="ISBN" id="ISBN"  value="${oldBookInfo.ISBN}" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">简介</span>
                    <%--<input type="text" class="form-control" name="introduction" id="introduction"  value="${oldBookInfo.introduction}" >--%>
                    <span>
                        <textarea class="form-control" name="introduction" id="introduction" style="height: 150px;">${oldBookInfo.introduction}</textarea>
                    </span>
                </div>
                <div class="input-group">
                    <span class="input-group-addon">语言</span>
                    <input type="text" class="form-control" name="language" id="language" value="${oldBookInfo.language}" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">价格</span>
                    <input type="text" class="form-control" name="price"  id="price" value="${oldBookInfo.price}">
                </div>
                <div class="input-group">
                    <span class="input-group-addon">出版日期</span>
                    <input type="date" class="form-control" name="pubDateStr" id="pubDateStr" value="<fmt:formatDate value="${oldBookInfo.pub_date}" pattern="yyyy-MM-dd"/>">
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">分类号</span>
                    <input type="text" class="form-control" name="class_id" id="class_id" value="${oldBookInfo.class_id}">
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">数量</span>
                    <input type="text" class="form-control" name="number"  id="number" value="${oldBookInfo.number}">
                </div>
                <input type="submit" value="确定" class="btn btn-success btn-sm" class="text-left">
                <script type="text/javascript">
                    // 去除收尾空格
                    function trim(str) {
                        return str.replace(/(^\s*)|(\s*$)/g, "");
                    }
                    // 表单项必填校验
                    $("#edit").submit(function () {
                        var $form = $(".form-control");
                        for (var i = 0; i < $form.length; i++) {
                            if (!trim($form[i].value)) {
                                alert("请填写完整图书信息");
                                return false;
                            }
                        }
                        return true;
                    })
                </script>
            </form>
        </div>
    </div>
</div>
</body>
</html>
