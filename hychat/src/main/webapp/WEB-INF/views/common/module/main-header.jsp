<%--
  Created by IntelliJ IDEA.
  User: buhuayang
  Date: 16/7/24
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<header class="main-header">

    <a href="${ctxPath}/login.htm" class="logo">
        <span class="logo-mini"><b>H</b>y</span>
        <span class="logo-lg"><b>Hy</b>CHAT</span>
    </a>

    <nav class="navbar navbar-static-top" role="navigation">

        <a href="javascript:void(0);" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="glyphicon glyphicon-th-list"></span>
        </a>

        <a href="#" class="sidebar-toggle">
            <span class="glyphicon glyphicon-repeat"></span>
        </a>

        <div class="navbar-custom-menu">
            <%--<ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" role="menu">
                        <li class="dropdown-backdrop"><a id="refresh" href="javascript:void(0);" data-url="">刷新</a></li>
                        &lt;%&ndash;<li class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                        <li class="divider"></li>
                        <li><a href="#">One more separated link</a></li>&ndash;%&gt;
                    </ul>
                </li>
            </ul>--%>
            <ul class="nav navbar-nav">

                <%--<li class="dropdown messages-menu">
                    <!-- Menu toggle button -->
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="fa fa-envelope-o"></i>
                        <span class="label label-success">4</span>
                    </a>
                    <ul class="dropdown-menu">
                        <li class="header">You have 4 messages</li>
                        <li>
                            <!-- inner menu: contains the messages -->
                            <ul class="menu">
                                <li><!-- start message -->
                                    <a href="#">
                                        <div class="pull-left">
                                            <!-- User Image -->
                                            <img src="${ctxPath}/assets/AdminLTE/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                                        </div>
                                        <!-- Message title and timestamp -->
                                        <h4>
                                            Support Team
                                            <small><i class="fa fa-clock-o"></i> 5 mins</small>
                                        </h4>
                                        <!-- The message -->
                                        <p>Why not buy a new awesome theme?</p>
                                    </a>
                                </li>
                                <!-- end message -->
                            </ul>
                            <!-- /.menu -->
                        </li>
                        <li class="footer"><a href="#">See All Messages</a></li>
                    </ul>
                </li>--%>

                <%--<li class="dropdown notifications-menu">
                    <!-- Menu toggle button -->
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="fa fa-bell-o"></i>
                        <span class="label label-warning">10</span>
                    </a>
                    <ul class="dropdown-menu">
                        <li class="header">You have 10 notifications</li>
                        <li>
                            <!-- Inner Menu: contains the notifications -->
                            <ul class="menu">
                                <li><!-- start notification -->
                                    <a href="#">
                                        <i class="fa fa-users text-aqua"></i> 5 new members joined today
                                    </a>
                                </li>
                                <!-- end notification -->
                            </ul>
                        </li>
                        <li class="footer"><a href="#">View all</a></li>
                    </ul>
                </li>--%>

                <%--<li class="dropdown tasks-menu">
                    <!-- Menu Toggle Button -->
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="fa fa-flag-o"></i>
                        <span class="label label-danger">9</span>
                    </a>
                    <ul class="dropdown-menu">
                        <li class="header">You have 9 tasks</li>
                        <li>
                            <!-- Inner menu: contains the tasks -->
                            <ul class="menu">
                                <li><!-- Task item -->
                                    <a href="#">
                                        <!-- Task title and progress text -->
                                        <h3>
                                            Design some buttons
                                            <small class="pull-right">20%</small>
                                        </h3>
                                        <!-- The progress bar -->
                                        <div class="progress xs">
                                            <!-- Change the css width attribute to simulate progress -->
                                            <div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                                <span class="sr-only">20% Complete</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <!-- end task item -->
                            </ul>
                        </li>
                        <li class="footer">
                            <a href="#">View all tasks</a>
                        </li>
                    </ul>
                </li>--%>

                <c:set var="sessionData" value="${sessionScope[WebKey.SESSION_DATA_KEY]}" scope="page"></c:set>
                <c:set var="chatUser" value="${sessionData.chatUser}" scope="page"></c:set>
                <li class="dropdown user user-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <c:if test="${not empty chatUser.headImgUrl}">
                            <img class="user-image" src="${ctxPath}/assets/AdminLTE/img/user4-128x128.jpg"/>
                        </c:if>
                        <c:if test="${empty chatUser.headImgUrl}">
                            <img class="user-image" src="${ctxPath}/assets/AdminLTE/img/avatar5.png"/>
                        </c:if>
                        <span class="hidden-xs">${chatUser.userName}</span>
                    </a>
                    <ul class="dropdown-menu">
                        <li class="user-header">
                            <c:if test="${not empty chatUser.headImgUrl}">
                                <img class="img-circle" src="${ctxPath}/assets/AdminLTE/img/user4-128x128.jpg"/>
                            </c:if>
                            <c:if test="${empty chatUser.headImgUrl}">
                                <img class="img-circle" src="${ctxPath}/assets/AdminLTE/img/avatar5.png"/>
                            </c:if>
                            <p>
                                Alexander Pierce - Web Developer
                                <small>注册时间:${sessionData.regDatetime}</small>
                            </p>
                        </li>
                        <li class="user-body">
                            <div class="row">
                                <div class="col-xs-4 text-center">
                                    <a href="#">Followers</a>
                                </div>
                                <div class="col-xs-4 text-center">
                                    <a href="#">Sales</a>
                                </div>
                                <div class="col-xs-4 text-center">
                                    <a href="#">Friends</a>
                                </div>
                            </div>
                        </li>
                        <li class="user-footer">
                            <div class="pull-left">
                                <a href="javascript:void(0);" class="btn btn-default btn-flat" onclick="HyChat.selectMenu('wdzh')">个人资料</a>
                            </div>
                            <div class="pull-right">
                                <a href="#" class="btn btn-default btn-flat">退出</a>
                            </div>
                        </li>
                    </ul>
                </li>

                <%--<li>
                    <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
                </li>--%>
            </ul>
        </div>
    </nav>
</header>
