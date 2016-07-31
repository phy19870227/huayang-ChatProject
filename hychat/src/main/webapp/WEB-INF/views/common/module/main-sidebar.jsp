<%--
  Created by IntelliJ IDEA.
  User: buhuayang
  Date: 16/7/24
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<aside class="main-sidebar">

    <section class="sidebar">

        <c:set var="chatUser" value="${sessionScope[WebKey.SESSION_DATA_KEY].chatUser}" scope="page"></c:set>
        <div class="user-panel">
            <div class="pull-left image">
                <c:if test="${not empty chatUser.headImgUrl}">
                    <img class="img-circle" src="${ctxPath}/assets/AdminLTE/img/user4-128x128.jpg"/>
                </c:if>
                <c:if test="${empty chatUser.headImgUrl}">
                    <img class="img-circle" src="${ctxPath}/assets/AdminLTE/img/avatar5.png"/>
                </c:if>
            </div>
            <div class="pull-left info">
                <p>${sessionScope[WebKey.SESSION_DATA_KEY].chatUser.userName}</p>
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>

        <ul class="sidebar-menu">
            <c:if test="${not empty applicationScope[WebKey.MAIN_SIDEBAR_KEY]}">
                <c:set var="menusets" value="${applicationScope[WebKey.MAIN_SIDEBAR_KEY]}"/>
                <c:forEach var="menuset" items="${menusets}" varStatus="status">
                    <c:if test="${menuset.type eq applicationScope['menusetTypeEnumSplit'].code}">
                        <li id="${menuset.id}" class="header">${menuset.name}</li>
                    </c:if>
                    <c:if test="${menuset.type eq applicationScope['menusetTypeEnumTree'].code}">
                        <li class="treeview">
                            <a data-menuset-id="${menuset.id}" data-menuset-name="${menuset.name}" href="#">
                                <i class="fa fa-link"></i>
                                <span>${menuset.name}</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <c:forEach var="menu" items="${menuset.menus}" varStatus="status">
                                    <li>
                                        <a href="javascript:void(0);"
                                           onclick="HyChat.clickMenu(this)"
                                           data-url="${ctxPath}${menu.url}"
                                           data-menu-id="${menu.id}" data-menu-name="${menu.name}"
                                           data-menuset-id="${menuset.id}">${menu.name}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </li>
                    </c:if>
                </c:forEach>
            </c:if>
        </ul>
    </section>
</aside>
