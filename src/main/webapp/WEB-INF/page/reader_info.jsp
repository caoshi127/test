<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>${readerCard.userName}的主页</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <script src="/js/jquery-3.2.1.js"></script>
    <script src="/js/bootstrap.min.js" ></script>
    <script>
        $(function () {
            $('#reader_header').load('reader_header.html');
        })
    </script>
</head>
<body background="/img/lizhi.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">
<div id="reader_header" style="padding-bottom: 80px"></div>
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

<div class="col-xs-5 col-md-offset-3">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">
                我的信息
            </h3>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <tr>
                    <th width="20%">读者证号</th>
                    <td>${readerInfo.reader_id}</td>
                </tr>
                <tr>
                    <th>姓名</th>
                    <td>${readerInfo.name}</td>
                </tr>
                <tr>
                    <th>性别</th>
                    <td>${readerInfo.gender}</td>
                </tr>
                <tr>
                    <th>生日</th>
                    <td>
                        <fmt:formatDate value="${readerInfo.birthday}" pattern="yyyy-MM-dd"/>
                    </td>
                </tr>
                <tr>
                    <th>地址</th>
                    <td>${readerInfo.address}</td>
                </tr>
                <tr>
                    <th>电话</th>
                    <td>${readerInfo.phone}</td>
                </tr>
                </tbody>
            </table>
        </div>
        <a class="btn btn-success btn-sm" href="reader_info_edit.html" role="button">修改</a>
    </div>
</div>

</body>
</html>
