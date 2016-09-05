<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/9/4 0004
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../../page/common/admin/css.jsp"/>
    <jsp:include page="../../page/common/admin/js.jsp"/>
    <jsp:include page="../../page/common/admin/validator.jsp"/>
    <jsp:include page="../../page/common/admin/loading.jsp"/>
    <title>后台登录</title>

    <script type="text/javascript">
        $(function () {
            var loading = Ladda.create(document.querySelector('#btnReg'));

            $("#btnBack").bind("click", function () {
                $("#page_content").load("user");
            });

            $("#btnReg").bind("click", function () {
                $('#roleForm').bootstrapValidator('validate');
                if ($('#roleForm').data('bootstrapValidator').isValid()) {
                    loading.start();
                    $.ajax({
                        type: "post",
                        dataType: "json",
                        url: "login",
                        data: $('#roleForm').serialize(),
                        success: function (data) {
                            loading.stop();
                            if (data.code === "1") {
                                toastr.success('登录成功');
                                $("#page_content").load("user");
                            } else {
                                toastr.error(data.desc);
                            }
                        },error: function (err) {
                            loading.stop();
                            toastr.error('操作失败');
                        }
                    });
                } else {
                    loading.stop();
                }
            });


            //验证开始
            $('.form-horizontal').bootstrapValidator({
                message: 'This value is not valid',
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    email: {
                        validators: {
                            notEmpty: {
                                message: '请输入邮箱'
                            }, regexp: {
                                regexp: '^[^@\\s]+@([^@\\s]+\\.)+[^@\\s]+$',
                                message: '格式不对'
                            }
                        }
                    }, password: {
                        validators: {
                            notEmpty: {
                                message: '请输入密码'
                            }, stringLength: {
                                min: 1,
                                max: 12,
                                message: '长度在1~12个字符长度'
                            }
                        }
                    }, confirmPassword: {
                        validators: {
                            notEmpty: {
                                message: '请输入密码'
                            },
                            identical: {
                                field: 'password',
                                message: "两次输入的密码不对"
                            }
                        }
                    }
                }
            });

            //验证结束
        });

    </script>
</head>
<body>
<form id="roleForm" class="form-horizontal" action="/back/login" method="post">
    <input id="id" type="hidden" name="id" value="${user.id}">

    <div class="form-group">
        <label class="col-sm-2 control-label">邮箱</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="email" placeholder="请输入注册邮箱...">
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">密码</label>
        <div class="col-sm-10">
            <input class="form-control" type="password" name="password" placeholder="请输入密码...">
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">确认密码</label>
        <div class="col-sm-10">
            <input class="form-control" type="password" name="confirmPassword" placeholder="请再次输入密码...">
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-10">
        </div>
        <div class="col-sm-2">
            <div style="text-align: right;">
                <button id="btnReg" class="btn btn-primary ladda-button" data-style="expand-right" type="button">
                    <span class="ladda-label">登录</span>
                </button>
            </div>
        </div>
    </div>

</form>
</body>
</html>
