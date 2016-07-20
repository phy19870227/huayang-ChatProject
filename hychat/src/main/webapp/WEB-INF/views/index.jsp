<%--
  Created by IntelliJ IDEA.
  User: buhuayang
  Date: 16/7/20
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<layout:extends name="main">
    <layout:put block="link">
        <link href="${ctxPath}/css/index.css" rel="stylesheet">
    </layout:put>
    <layout:put block="container">
        <div class="starter-template">
            <h1>hychat聊天</h1>
            <p class="lead">本项目仅供技术学习。<br> 欢迎发送邮件到snake19870227@vip.qq.com讨论。</p>
        </div>

        <form class="form-signin">
            <h2 class="form-signin-heading">登录</h2>
            <input type="text" id="user_code" name="userCode" class="form-control" placeholder="用户名" autofocus/>
            <input type="password" id="user_pwd" name="userPwd" class="form-control" placeholder="密码"/>
                <%--<div class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>--%>
            <button id="btn_login" class="btn btn-lg btn-primary btn-block" type="button">登录</button>
            <button id="btn_register" class="btn btn-lg btn-success btn-block" type="button">注册</button>
        </form>
    </layout:put>
    <layout:put block="script">
        <script src="${ctxPath}/js/index.js"></script>
    </layout:put>
</layout:extends>
