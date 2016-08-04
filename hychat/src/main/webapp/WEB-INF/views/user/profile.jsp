<%--
  Created by IntelliJ IDEA.
  User: buhuayang
  Date: 16/7/30
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<c:set var="chatUser" value="${sessionScope[WebKey.SESSION_DATA_KEY].chatUser}" scope="page"></c:set>
<div class="row">
    <div class="col-md-3">

        <!-- Profile Image -->
        <div class="box box-primary">
            <div class="box-body box-profile">
                <c:if test="${not empty chatUser.headImgUrl}">
                    <img class="profile-user-img img-responsive img-circle" src="${chatUser.headImgUrl}"/>
                </c:if>
                <c:if test="${empty chatUser.headImgUrl}">
                    <img class="profile-user-img img-responsive img-circle" src="${ctxPath}/assets/AdminLTE/img/avatar5.png"/>
                </c:if>

                <h3 class="profile-username text-center">${chatUser.userName}</h3>

                <%--<p class="text-muted text-center">Software Engineer</p>--%>

                <%--<ul class="list-group list-group-unbordered">
                    <li class="list-group-item">
                        <b>Followers</b> <a class="pull-right">1,322</a>
                    </li>
                    <li class="list-group-item">
                        <b>Following</b> <a class="pull-right">543</a>
                    </li>
                    <li class="list-group-item">
                        <b>Friends</b> <a class="pull-right">13,287</a>
                    </li>
                </ul>--%>

                <%--<a href="#" class="btn btn-primary btn-block"><b>Follow</b></a>--%>
            </div>
            <!-- /.box-body -->
        </div>
        <!-- /.box -->

        <!-- About Me Box -->
        <div class="box box-primary">
            <div class="box-header with-border">
                <h3 class="box-title">About Me</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
                <strong><i class="fa fa-book margin-r-5"></i> Education</strong>

                <p class="text-muted">
                    B.S. in Computer Science from the University of Tennessee at Knoxville
                </p>

                <hr>

                <strong><i class="fa fa-map-marker margin-r-5"></i> Location</strong>

                <p class="text-muted">Malibu, California</p>

                <hr>

                <strong><i class="fa fa-pencil margin-r-5"></i> Skills</strong>

                <p>
                    <span class="label label-danger">UI Design</span>
                    <span class="label label-success">Coding</span>
                    <span class="label label-info">Javascript</span>
                    <span class="label label-warning">PHP</span>
                    <span class="label label-primary">Node.js</span>
                </p>

                <hr>

                <strong><i class="fa fa-file-text-o margin-r-5"></i> Notes</strong>

                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam fermentum enim neque.</p>
            </div>
            <!-- /.box-body -->
        </div>
        <!-- /.box -->
    </div>
    <!-- /.col -->
    <div class="col-md-9">
        <div class="nav-tabs-custom">
            <ul class="nav nav-tabs">
                <li class="active"><a href="#settings" data-toggle="tab">个人资料</a></li>
                <li><a href="#head_img" data-toggle="tab">头像</a></li>
            </ul>
            <div class="tab-content">
                <div class="active tab-pane" id="settings">
                    <form id="profile_form" action="${ctxPath}/user/profile.htm" method="post" class="form-horizontal">
                        <div class="form-group">
                            <label for="userName" class="col-sm-2 control-label">昵称</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="userName" name="userName" value="${chatUser.userName}" placeholder="Name">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button id="profile_save_btn" type="button" class="btn btn-primary">保存</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="tab-pane" id="head_img">
                    <form id="head_img_form" action="${ctxPath}/user/profile.htm" method="post"
                          enctype="multipart/form-data" class="form-horizontal">
                        <div class="form-group">
                            <label for="headImg" class="col-sm-2 control-label">头像</label>
                            <div class="col-sm-10">
                                <input type="file" id="headImg" name="headImg" class="file" accept="image/*"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button id="head_img_save_btn" type="button" class="btn btn-primary">保存</button>
                            </div>
                        </div>
                    </form>
                </div>
                <!-- /.tab-pane -->
            </div>
            <!-- /.tab-content -->
        </div>
        <!-- /.nav-tabs-custom -->
    </div>
    <!-- /.col -->
</div>