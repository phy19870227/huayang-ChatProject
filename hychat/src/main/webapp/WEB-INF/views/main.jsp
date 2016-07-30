<%--
  Created by IntelliJ IDEA.
  User: buhuayang
  Date: 16/7/20
  Time: 23:37
--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>HyChat</title>

    <link rel="stylesheet" href="${ctxPath}/assets/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctxPath}/assets/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${ctxPath}/assets/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="${ctxPath}/assets/AdminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="${ctxPath}/assets/AdminLTE/css/skins/skin-blue.min.css">

    <!--[if lt IE 9]>
    <script src="${ctxPath}/assets/plugins/html5shiv.min.js"></script>
    <script src="${ctxPath}/assets/plugins/respond.min.js"></script>
    <![endif]-->
</head>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <jsp:include page="common/module/main-header.jsp"></jsp:include>

    <jsp:include page="common/module/main-sidebar.jsp"></jsp:include>

    <div class="content-wrapper">

        <section class="content-header">
            <h1>
                <span id="menu_name">Page Header</span>
                <small id="menuset_name">Optional description</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li id="path_menu_name" class="active">Here</li>
            </ol>
        </section>

        <section class="content">

        </section>

    </div>

    <jsp:include page="common/module/main-footer.jsp"></jsp:include>

    <jsp:include page="common/module/control-sidebar.jsp"></jsp:include>
</div>

<script src="${ctxPath}/assets/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="${ctxPath}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>

<script src="${ctxPath}/assets/plugins/sockjs/sockjs-1.1.1.min.js"></script>
<script src="${ctxPath}/assets/plugins/stomp/stomp.min.js"></script>
<script src="${ctxPath}/assets/plugins/jquery.blockUI.js"></script>
<script src="${ctxPath}/assets/plugins/fastclick/fastclick.js"></script>

<script src="${ctxPath}/assets/AdminLTE/js/app.js"></script>

<script src="${ctxPath}/js/Util.js"></script>
<script src="${ctxPath}/js/HyChat.js"></script>
<script src="${ctxPath}/js/WebStomp.js"></script>
</body>
</html>
