<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pengweiyuan
  Date: 7/20/16
  Time: 10:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../../page/common/admin/css.jsp"/>
    <jsp:include page="../../page/common/admin/js.jsp"/>
    <jsp:include page="../../page/common/admin/validator.jsp"/>
    <jsp:include page="../../page/common/admin/loading.jsp"/>

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
                        url: "saveUser",
                        data: $('#roleForm').serialize(),
                        success: function (data) {
                            loading.stop();
                            if (data.code === "1") {
                                toastr.success('操作成功');
                                $("#page_content").load("user");
                            } else {
                                toastr.error('操作失败');
                            }
                        },
                        error: function (err) {
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
                    userName: {
                        validators: {
                            notEmpty: {
                                message: '请输入用户名'
                            },
                            stringLength: {
                                min: 1,
                                max: 50,
                                message: '长度在1~50个字符长度'
                            }
                        }
                    }, mobile: {
                        validators: {
                            phone: {
                                country: 'CN',
                                message: '格式不对'
                            }, notEmpty: {
                                message: '请输入手机号码'
                            }
                        }
                    }, nickName: {
                        validators: {
                            notEmpty: {
                                message: '请输入昵称'
                            },
                            stringLength: {
                                min: 1,
                                max: 200,
                                message: '长度在1~200个字符长度'
                            }
                        }
                    }, email: {
                        validators: {
                            notEmpty: {
                                message: '请输入邮箱'
                            }, regexp: {
                                regexp: '^[^@\\s]+@([^@\\s]+\\.)+[^@\\s]+$',
                                message: '格式不对'
                            }, remote: {
                                url: 'checkEmail',//验证地址
                                message: 'email已存在',//提示消息
                                delay: 2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
                                type: 'POST'//请求方式
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
                            }, identical: {
                                field: 'confirmPassword',
                                message: "两次输入的密码不对"
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
<form id="roleForm" class="form-horizontal">
    <input id="id" type="hidden" name="id" value="${user.id}">

    <div class="form-group">
        <label class="col-sm-2 control-label">用户名</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="userName" placeholder="请输入用户名..." value="${user.userName}">
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
        <label class="col-sm-2 control-label">电话</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="mobile" placeholder="请输入别名..." value="${user.mobile}">
        </div>
    </div>


    <div class="form-group">
        <label class="col-sm-2 control-label">昵称</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="nickName" placeholder="请输入昵称..." value="${user.nickName}">
        </div>
    </div>


    <div class="form-group">
        <label class="col-sm-2 control-label">邮箱</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="email" placeholder="请输入邮箱..." value="${user.email}">
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">性别</label>
        <div class="btn-group" data-toggle="buttons" style="padding-left: 15px;">
            <label class="btn btn-default">
                <input type="radio" name="sex" value="0" <c:if test="${user.sex==0}"> checked="checked"</c:if> /> 男
            </label>
            <label class="btn btn-default">
                <input type="radio" name="sex" value="1" <c:if test="${user.sex==1}"> checked="checked"</c:if> /> 女
            </label>
            <label class="btn btn-default">
                <input type="radio" name="sex" value="2" <c:if test="${user.sex==2}"> checked="checked"</c:if> /> 妖
            </label>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-10">
        </div>
        <div class="col-sm-2">
            <div style="text-align: right;">

                <button id="btnBack" class="btn btn-primary ladda-button" data-style="expand-right" type="button">
                    <span class="ladda-label">返回列表</span>
                </button>
                <button id="btnReg" class="btn btn-primary ladda-button" data-style="expand-right" type="button">
                    <span class="ladda-label">提交</span>
                </button>
            </div>
        </div>
    </div>
</form>
</body>
</html>
