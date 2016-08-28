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
                        url: "saveMenu",
                        data: $('#roleForm').serialize(),
                        success: function (data) {
                            loading.stop();
                            if (data.code === "1") {
                                toastr.success('操作成功');
                                $("#page_content").load("menuIndex");
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
                    name: {
                        validators: {
                            notEmpty: {
                                message: '请输入名称'
                            },
                            stringLength: {
                                min: 1,
                                max: 50,
                                message: '长度在1~50个字符长度'
                            }
                        }
                    }, aliasName: {
                        validators: {
                            notEmpty: {
                                message: '请输入别名'
                            },
                            stringLength: {
                                min: 1,
                                max: 50,
                                message: '长度在1~50个字符长度'
                            }
                        }
                    }, url: {
                        validators: {
                            notEmpty: {
                                message: '请输入url'
                            },
                            stringLength: {
                                min: 1,
                                max: 200,
                                message: '长度在1~200个字符长度'
                            }
                        }
                    }, order: {
                        validators: {
                            notEmpty: {
                                message: '请输入排序'
                            },digits: {
                                message: '只能输入数字'
                            },
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
    <input id="id" type="hidden" name="id" value="${menu.id}">

    <div class="form-group">
        <label class="col-sm-2 control-label">用户名</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="userName" placeholder="请输入用户名..." value="${menu.name}">
        </div>
    </div>


    <div class="form-group">
        <label class="col-sm-2 control-label">别名</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="aliasName" placeholder="请输入别名..." value="${menu.aliasName}">
        </div>
    </div>


    <div class="form-group">
        <label class="col-sm-2 control-label">url</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="url" placeholder="请输入路径..." value="${menu.url}">
        </div>
    </div>


    <div class="form-group">
        <label class="col-sm-2 control-label">排序</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="order" placeholder="请输入路径..." value="${menu.order}">
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
