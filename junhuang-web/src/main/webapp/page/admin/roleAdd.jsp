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
            var loading=Ladda.create(document.querySelector('#btnReg'));

            $("#btnBack").bind("click",function(){
                $("#page_content").load("roleIndex");
            });

            $("#btnReg").bind("click",function(){
                $('#roleForm').bootstrapValidator('validate');
                if($('#roleForm').data('bootstrapValidator').isValid()){
                    loading.start();
                    $.ajax({
                        type: "post",
                        dataType: "json",
                        url: "saveRole",
                        data: $('#roleForm').serialize(),
                        success: function(data) {
                            loading.stop();
                            if(data.code==="1"){
                                toastr.success('操作成功');
                                $("#page_content").load("roleIndex");
                            }else{
                                toastr.error('操作失败');
                            }
                        },
                        error: function(err) {
                            loading.stop();
                            toastr.error('操作失败');
                        }
                    });
                }else{
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
                    roleName: {
                        validators: {
                            notEmpty: {
                                message: '请输入角色名称'
                            },
                            stringLength: {
                                min:1,
                                max: 50,
                                message: '角色名称长度在3~50个字符长度'
                            }
                        }
                    },
                    permissionStr: {
                        validators: {
                            notEmpty: {
                                message: '请输入权限:(xxx:xx)'
                            },
                            stringLength: {
                                min:1,
                                max: 200,
                                message: '权限长度在1~1000个字符长度'
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
    <input id="id" type="hidden" name="id" value="${role.id}">

    <div class="form-group">
        <label class="col-sm-2 control-label">角色名字</label>
        <div class="col-sm-10">
            <input class="form-control"  type="text" name="roleName" placeholder="请输入角色名字..." value="${role.roleName}">
        </div>
    </div>


    <div class="form-group">
        <label class="col-sm-2 control-label">描述</label>
        <div class="col-sm-10">
            <input class="form-control"  type="text" name="description" placeholder="请输入描述..." value="${role.description}">
        </div>
    </div>


    <div class="form-group">
        <label class="col-sm-2 control-label">权限</label>
        <div class="col-sm-10">
            <input class="form-control"  type="text" name="permissionStr" placeholder="请输入权限..." value="${role.permissionStr}">
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
