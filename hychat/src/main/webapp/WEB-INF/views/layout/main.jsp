<%--
  Created by IntelliJ IDEA.
  User: buhuayang
  Date: 16/7/20
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>hychat聊天</title>

    <link href="${ctxPath}/css/bootstrap.min.css" rel="stylesheet">

    <link href="${ctxPath}/css/base.css" rel="stylesheet">
    <layout:block name="link"/>

    <!--[if lt IE 9]>
    <script src="${ctxPath}/js/html5shiv.min.js"></script>
    <script src="${ctxPath}/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<jsp:include page="/WEB-INF/views/common/module/head.jsp"></jsp:include>
<div class="container">
    <layout:block name="container"/>
</div>
<jsp:include page="/WEB-INF/views/common/module/footer.jsp"></jsp:include>

<script src="${ctxPath}/js/jquery.min.js"></script>
<script src="${ctxPath}/js/bootstrap.min.js"></script>
<script src="${ctxPath}/js/base.js"></script>
<layout:block name="script"/>
</body>
</html>