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
                <div class="col-md-9 input-group">
                    <input type="text" class="form-control" id="user_code" name="userCode" placeholder="用户名" aria-describedby="user_code_help_block"
                           autofocus/>
                    <span id="user_code_help_block" class="help-block hidden"></span>
                </div>
            </div>
            <div class="form-group">
                <label for="user_pwd" class="col-md-3 control-label">密码</label>
                <div class="col-md-9 input-group">
                    <input type="password" class="form-control" id="user_pwd" name="userPwd" placeholder="密码"/>
                </div>
            </div>
            <div class="form-group">
                <label for="repeat_user_pwd" class="col-md-3 control-label">确认密码</label>
                <div class="col-md-9 input-group">
                    <input type="password" class="form-control" id="repeat_user_pwd" name="repeatUserPwd"
                           placeholder="确认密码"/>
                </div>
            </div>
            <div class="form-group">
                <label for="check_code" class="col-md-3 control-label check-img" style="padding-top: 20px;">验证码</label>
                <div class="col-md-9 input-group">
                    <input type="password" class="form-control input-lg check-img" id="check_code" name="checkCode"
                           placeholder="验证码"/>
                    <div class="input-group-addon check-img">
                        <img id="check_code_img" src="${ctxPath}/check.jpg" title="看不清，点击换一张"/>
                    </div>
                </div>
            </div>
            <div class="text-center">
                <button type="button" class="btn btn-default btn-lg">注册</button>
            </div>
        </form>
    </layout:put>
    <layout:put block="script">
        <script src="${ctxPath}/js/register.js"></script>
    </layout:put>
</layout:extends>