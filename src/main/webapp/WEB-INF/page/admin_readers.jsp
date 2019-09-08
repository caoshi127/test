<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>全部读者</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(function () {

            $("#admin_header").load("/admin_header.html");
        })
    </script>
</head>
<body background="img/u1.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">
<div id="admin_header"></div>
<div class="panel panel-default" style="position:relative;top: 80px;width: 90%;margin-left: 5%">
    <div class="panel-heading">
        <h3 class="panel-title">
            全部读者
        </h3>
    </div>
    <div class="panel-body">
        <table class="table table-hover" >
            <thead>
            <tr>
                <th>读者号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>生日</th>
                <th>家庭地址</th>
                <th>电话</th>
                <th>编辑</th>
                <th>删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${readers}" var="reader">
                <tr>
                    <td><c:out value="${reader.reader_id}"></c:out></td>
                    <td><c:out value="${reader.name}"></c:out></td>
                    <td><c:out value="${reader.gender}"></c:out></td>
                    <td>
                        <fmt:formatDate value="${reader.birthday}" pattern="yyyy-MM-dd"></fmt:formatDate>
                    </td>
                    <td><c:out value="${reader.address}"></c:out></td>
                    <td><c:out value="${reader.phone}"></c:out></td>
                    <td><a href="reader_edit.html?reader_id=<c:out value="${reader.reader_id}"></c:out>"><button type="button" class="btn btn-info btn-xs">编辑读者</button></a></td>
                    <td><a href="reader_delete_do?reader_id=<c:out value="${reader.reader_id}"></c:out>"><button type="button" class="btn btn-danger btn-xs">删除读者</button></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
