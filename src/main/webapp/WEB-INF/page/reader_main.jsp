<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${readerCard.userName}的主页</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <script src="/js/jquery-3.2.1.js"></script>
    <script src="/js/bootstrap.min.js" ></script>
    <script>
        $(function () {
            $('#reader_header').load('/reader_header.html');
        })
    </script>
</head>
<body background="/img/wolf.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">
<div id="reader_header"></div>

</body>
</html>
