<%--
  Created by IntelliJ IDEA.
  User: buhuayang
  Date: 16/7/20
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<layout:extends name="main">
    <layout:put block="link">
        <link href="${ctxPath}/css/register.css" rel="stylesheet">
    </layout:put>
    <layout:put block="container">
        <form class="form-signup form-horizontal">
            <div class="form-group">
                <label for="user_code" class="col-md-3 control-label">用户名</label>
                <div class="col-md-9">
                    <input type="email" class="form-control" id="user_code" name="userCode" placeholder="用户名"
                           autofocus/>
                </div>
            </div>
            <div class="form-group">
                <label for="user_pwd" class="col-md-3 control-label">密码</label>
                <div class="col-md-9">
                    <input type="password" class="form-control" id="user_pwd" name="userPwd" placeholder="密码"/>
                </div>
            </div>
            <div class="form-group">
                <label for="repeat_user_pwd" class="col-md-3 control-label">确认密码</label>
                <div class="col-md-9">
                    <input type="password" class="form-control" id="repeat_user_pwd" name="repeatUserPwd"
                           placeholder="确认密码"/>
                </div>
            </div>
            <button type="button" class="btn btn-default btn-block">注册</button>
        </form>
    </layout:put>
    <layout:put block="script">

    </layout:put>
</layout:extends>