<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>我的借还</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
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
<div id="reader_header" style="padding-bottom: 80px"></div>
<div class="panel panel-default" style="width: 90%;margin-left: 5%;margin-top: 0%">
    <div class="panel-heading">
        <h3 class="panel-title">
            我的借还日志
        </h3>
    </div>
    <div class="panel-body">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>图书号</th>
                <th>借出日期</th>
                <th>归还日期</th>
                <th>状态</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${lendInfos}" var="alog">
                <tr>
                    <td><c:out value="${alog.book_id}"></c:out></td>
                    <td>
                        <fmt:formatDate value="${alog.lend_date}" pattern="yyyy-MM-dd"/>
                    </td>
                    <td>
                        <fmt:formatDate value="${alog.back_date}" pattern="yyyy-MM-dd"/>
                    </td>
                    <c:if test="${empty alog.back_date}">
                        <td>未还</td>
                    </c:if>
                    <c:if test="${!empty alog.back_date}">
                        <td>已还</td>
                    </c:if>
                    <c:if test="">
                        <td>超期</td>
                    </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
