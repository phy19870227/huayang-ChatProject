<%--
  Created by IntelliJ IDEA.
  User: buhuayang
  Date: 16/7/28
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<div class="row">
    <div class="col-md-9">
        <div id="chat-room-box" class="box box-primary direct-chat direct-chat-primary margin-bottom-none">
            <div class="box-header with-border">
                <h3 class="box-title">聊天</h3>
            </div>
            <div class="box-body">
                <div class="direct-chat-messages">
                    <div class="direct-chat-msg">
                        <div class="direct-chat-info clearfix">
                            <span class="direct-chat-name pull-left">Alexander Pierce</span>
                            <span class="direct-chat-timestamp pull-right">23 Jan 2:00 pm</span>
                        </div>
                        <img class="direct-chat-img" src="${ctxPath}/assets/AdminLTE/img/user1-128x128.jpg" alt="Message User Image"><!-- /.direct-chat-img -->
                        <div class="direct-chat-text">Is this template really for free? That's unbelievable!</div>
                    </div>
                    <div class="direct-chat-msg right">
                        <div class="direct-chat-info clearfix">
                            <span class="direct-chat-name pull-right">Sarah Bullock</span>
                            <span class="direct-chat-timestamp pull-left">23 Jan 2:05 pm</span>
                        </div>
                        <img class="direct-chat-img" src="${ctxPath}/assets/AdminLTE/img/user3-128x128.jpg" alt="Message User Image"><!-- /.direct-chat-img -->
                        <div class="direct-chat-text">You better believe it!</div>
                    </div>
                </div>
            </div>
            <div class="box-footer">
                <form action="#" method="post">
                    <div class="input-group">
                        <input type="text" name="message" placeholder="Type Message ..." class="form-control">
                        <span class="input-group-btn">
                            <button type="button" class="btn btn-primary btn-flat">Send</button>
                        </span>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
