<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>全部图书信息</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#admin_header").load("/admin_header.html");
        })
    </script>
</head>
<body background="/img/book1.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">
<%--头部导航栏--%>
<div id="admin_header"></div>

<%--图书搜索框--%>
<div style="padding: 70px 550px 10px">
    <form action="admin_querybooks_do" method="post" class="form-inline" id="searchform">
        <div>
            <div class="input-group">
                <input type="text" class="form-control" placeholder="请输入关键字" name="searchWords">
                <span class="input-group-btn">
                    <input class="btn btn-default" type="submit" value="搜索"/>
                </span>
            </div>
        </div>
    </form>
</div>

<%--图书展示列表--%>
<div class="panel panel-default" style="width: 90%;margin-left: 5%">
    <div class="panel-heading" style="background-color: #fff">
        <h3 class="panel-title">
            全部图书
        </h3>
    </div>
    <div class="panel-body">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>书名</th>
                <th>作者</th>
                <th>出版社</th>
                <th>ISBN</th>
                <th>价格</th>
                <th>剩余数量</th>
                <th>详情</th>
                <th>编辑</th>
                <th>删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${bookInfos}" var="bookInfo">
                <tr>
                    <td><c:out value="${bookInfo.name}"></c:out></td>
                    <td><c:out value="${bookInfo.author}"></c:out></td>
                    <td><c:out value="${bookInfo.publish}"></c:out></td>
                    <td><c:out value="${bookInfo.ISBN}"></c:out></td>
                    <td><c:out value="${bookInfo.price}"></c:out></td>
                    <td><c:out value="${bookInfo.number}"></c:out></td>
                    <td>
                        <a href="admin_book_detail.html?bookId=<c:out value="${bookInfo.book_id}"></c:out>">
                            <button type="button" class="btn btn-success btn-xs">详情</button>
                        </a>
                    </td>
                    <td>
                        <a href="admin_updatebook.html?bookId=<c:out value="${bookInfo.book_id}"></c:out>">
                            <button type="button" class="btn btn-info btn-xs">编辑</button>
                        </a>
                    </td>
                    <td>
                        <a href="admin_deletebook_do?bookId=<c:out value="${bookInfo.book_id}"></c:out>">
                            <button type="button" class="btn btn-danger btn-xs" onclick="">删除</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
